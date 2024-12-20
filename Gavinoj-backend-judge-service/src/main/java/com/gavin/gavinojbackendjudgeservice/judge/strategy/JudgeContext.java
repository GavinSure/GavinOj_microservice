package com.gavin.gavinojbackendjudgeservice.judge.strategy;


import com.Gavin.gavinojbackendmodel.codesandbox.JudgeInfo;
import com.Gavin.gavinojbackendmodel.dto.question.JudgeCase;
import com.Gavin.gavinojbackendmodel.entity.Question;
import com.Gavin.gavinojbackendmodel.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @author: Gavin
 * @description: 上下文，用于定义在策略中传递的参数
 * @className: JudgeContext
 * @date: 2024/4/20 13:42
 * @version:0.1
 * @since: jdk14.0
 */
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
