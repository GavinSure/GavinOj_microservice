package com.gavin.gavinojbackendjudgeservice.controller.inner;



import com.Gavin.gavinojbackendmodel.entity.QuestionSubmit;
import com.gavin.gavinojbackendjudgeservice.judge.JudgeService;

import com.gavin.gavinojbackendserviceclient.service.JudgeFeignClient;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;

    @Override
    @PostMapping("/do")
    public QuestionSubmit doJudge(@RequestParam("questionSubmitId)") long questionSubmitId){
        return judgeService.doJudge(questionSubmitId);
    }

}
