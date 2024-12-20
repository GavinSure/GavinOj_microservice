package com.gavin.gavinojbackendserviceclient.service;


import com.Gavin.gavinojbackendmodel.entity.Question;
import com.Gavin.gavinojbackendmodel.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author sms
 * @description 针对表【question(题目)】的数据库操作Service
 * @createDate 2024-04-13 13:52:37
 */
@FeignClient(name = "Gavinoj-backend-question-service",path = "/api/question/inner")
public interface QuestionFeignClient{

    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long id);

    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId);

    @PostMapping("/question_submit/update")
    boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit);

}
