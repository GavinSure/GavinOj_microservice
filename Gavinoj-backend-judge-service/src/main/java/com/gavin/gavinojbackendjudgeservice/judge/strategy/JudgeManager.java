package com.gavin.gavinojbackendjudgeservice.judge.strategy;


import com.Gavin.gavinojbackendmodel.codesandbox.JudgeInfo;
import com.Gavin.gavinojbackendmodel.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @author: Gavin
 * @description: 判题管理（为了简化不同策略模式的调用）
 * @className: StrategyManager
 * @date: 2024/4/20 14:40
 * @version:0.1
 * @since: jdk14.0
 */
@Service
public class JudgeManager {
    //执行判题
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
