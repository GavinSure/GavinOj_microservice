package com.gavin.gavinojbackendjudgeservice.judge;


import com.Gavin.gavinojbackendmodel.entity.QuestionSubmit;

/**
 * @author: Gavin
 * @description: 判题服务
 * @className: JudgeService
 * @date: 2024/4/13 16:44
 * @version:0.1
 * @since: jdk14.0
 */
public interface JudgeService {

    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}