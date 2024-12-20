package com.gavin.gavinojbackendquestionservice.service;


import com.Gavin.gavinojbackendmodel.entity.CompetitionQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author sms
* @description 针对表【competition_question】的数据库操作Service
* @createDate 2024-04-27 16:31:42
*/
public interface CompetitionQuestionService extends IService<CompetitionQuestion> {
    List<Long> selectQuestionIdsByCompetitionId(Long competitionId);
}
