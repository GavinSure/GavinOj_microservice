package com.gavin.gavinojbackendjudgeservice.judge.strategy;


import com.Gavin.gavinojbackendmodel.codesandbox.JudgeInfo;

/**
 * @author: Gavin
 * @description: 判题策略
 * @className: JudgeStrategy
 * @date: 2024/4/20 13:39
 * @version:0.1
 * @since: jdk14.0
 */
public interface JudgeStrategy {
    //执行判题
    JudgeInfo doJudge(JudgeContext judgeContext);
}
