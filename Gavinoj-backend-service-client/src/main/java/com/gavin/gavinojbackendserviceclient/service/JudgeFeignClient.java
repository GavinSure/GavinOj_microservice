package com.gavin.gavinojbackendserviceclient.service;

import com.Gavin.gavinojbackendmodel.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Gavin
 * @description: 判题服务
 * @className: JudgeService
 * @date: 2024/4/13 16:44
 * @version:0.1
 * @since: jdk14.0
 */
@FeignClient(name = "Gavinoj-backend-judge-service",path = "/api/judge")
public interface JudgeFeignClient {

    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    @PostMapping("/do")
    QuestionSubmit doJudge(@RequestParam("questionSubmitId)") long questionSubmitId);
}