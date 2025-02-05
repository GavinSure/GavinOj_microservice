package com.gavin.gavinojbackendjudgeservice.judge.codesandbox.impl;



import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeResponse;
import com.Gavin.gavinojbackendmodel.codesandbox.JudgeInfo;
import com.Gavin.gavinojbackendmodel.enums.JudgeInfoMessageEnum;
import com.Gavin.gavinojbackendmodel.enums.QuestionSubmitStatusEnum;
import com.gavin.gavinojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author: Gavin
 * @description: 示例代码沙箱
 * @className: ExampleCodeSandbox
 * @date: 2024/4/18 21:48
 * @version:0.1
 * @since: jdk14.0
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {

        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
