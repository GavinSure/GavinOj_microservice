package com.gavin.gavinojbackendquestionservice.controller;


import com.Gavin.gavinojbackendmodel.dto.competition.CompetitionQueryRequest;
import com.Gavin.gavinojbackendmodel.entity.Competition;
import com.Gavin.gavinojbackendmodel.entity.Question;
import com.Gavin.gavinojbackendmodel.vo.CompetitionQuestionVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gavin.Gavinojbackendcommon.common.BaseResponse;
import com.gavin.Gavinojbackendcommon.common.ResultUtils;
import com.gavin.gavinojbackendquestionservice.service.CompetitionQuestionService;
import com.gavin.gavinojbackendquestionservice.service.CompetitionService;
import com.gavin.gavinojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gavin
 * @description:
 * @className: CompetitionController
 * @date: 2024/4/27 15:51
 * @version:0.1
 * @since: jdk14.0
 */
@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Resource
    private CompetitionService competitionService;

    @Resource
    private CompetitionQuestionService competitionQuestionService;

    @Resource
    private QuestionFeignClient questionFeignClient;

    @PostMapping("/list")
    public BaseResponse<Page<Competition>> listCompetition(@RequestBody CompetitionQueryRequest competitionQueryRequest) {
        long current = competitionQueryRequest.getCurrent();
        long size = competitionQueryRequest.getPageSize();
        //从数据库中查询原始竞赛信息
        Page<Competition> competitionPage = competitionService.page(new Page<>(current,size));
        return ResultUtils.success(competitionPage);
    }

    //根据竞赛id查包含的题目
    @GetMapping("/questions")
    public BaseResponse<CompetitionQuestionVO> competitionQuestion(Long id){
        List<Long> questionIds = competitionQuestionService.selectQuestionIdsByCompetitionId(id);
        List<Question> questions=new ArrayList<>();
        for(Long questionId : questionIds){
            Question question=questionFeignClient.getQuestionById(questionId);
            questions.add(question);
        }
        Competition competition=competitionService.getById(id);
        CompetitionQuestionVO competitionQuestionVO=new CompetitionQuestionVO();
        competitionQuestionVO.setQuestions(questions);
        competitionQuestionVO.setCompetition(competition);
        return ResultUtils.success(competitionQuestionVO);
    }
}
