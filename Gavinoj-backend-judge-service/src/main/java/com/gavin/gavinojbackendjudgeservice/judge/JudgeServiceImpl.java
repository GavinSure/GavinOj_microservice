package com.gavin.gavinojbackendjudgeservice.judge;

import cn.hutool.json.JSONUtil;

import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeResponse;
import com.Gavin.gavinojbackendmodel.codesandbox.JudgeInfo;
import com.Gavin.gavinojbackendmodel.dto.question.JudgeCase;
import com.Gavin.gavinojbackendmodel.entity.Question;
import com.Gavin.gavinojbackendmodel.entity.QuestionSubmit;
import com.Gavin.gavinojbackendmodel.enums.QuestionSubmitStatusEnum;
import com.gavin.Gavinojbackendcommon.common.ErrorCode;
import com.gavin.Gavinojbackendcommon.exception.BusinessException;
import com.gavin.gavinojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.gavin.gavinojbackendjudgeservice.judge.codesandbox.CodeSandboxFactory;
import com.gavin.gavinojbackendjudgeservice.judge.codesandbox.CodeSandboxProxy;
import com.gavin.gavinojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.gavin.gavinojbackendjudgeservice.judge.strategy.JudgeContext;
import com.gavin.gavinojbackendjudgeservice.judge.strategy.JudgeManager;
import com.gavin.gavinojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.gavin.gavinojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Gavin
 * @description:
 * @className: JudgeServiceImpl
 * @date: 2024/4/13 16:47
 * @version:0.1
 * @since: jdk14.0
 */
@Service
public class JudgeServiceImpl implements JudgeService {

    @Resource
    private QuestionFeignClient questionFeignClient;


    @Resource
    private JudgeManager judgeManager;

    @Value("${codesandbox.type:example}")
    private String type;

    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {

        //1.传入题目的提交id，获取对应的题目、提交信息
        QuestionSubmit questionSubmit = questionFeignClient.getQuestionSubmitById(questionSubmitId);
        if (questionSubmit == null)
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "提交信息不存在");
        Long questionId = questionSubmit.getQuestionId();
        Question question = questionFeignClient.getQuestionById(questionId);
        if (question == null)
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目不存在");
        //判题状态为等待则不需要提交
        if (!questionSubmit.getStatus().equals(QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "判题中，请等待");
        }
        //更新判题状态
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean update = questionFeignClient.updateQuestionSubmitById(questionSubmitUpdate);
        if (!update)
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目状态更新错误");

        //2.调用沙箱执行
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        //获取问题本身的测试用例
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        //从提交中获取信息
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());

        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        //执行代码
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutputList();
        //3.根据执行结果设置判题状态
        JudgeContext judgeContext = new JudgeContext();
        executeCodeResponse.getJudgeInfo().setMessage(executeCodeResponse.getMessage());
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestion(question);
        judgeContext.setQuestionSubmit(questionSubmit);
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);

        //4.修改数据库中的判题结果
        questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        update = questionFeignClient.updateQuestionSubmitById(questionSubmitUpdate);
        if (!update)
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目状态更新错误");

        QuestionSubmit questionSubmitResult = questionFeignClient.getQuestionSubmitById(questionId);
        return questionSubmitResult;
    }
}
