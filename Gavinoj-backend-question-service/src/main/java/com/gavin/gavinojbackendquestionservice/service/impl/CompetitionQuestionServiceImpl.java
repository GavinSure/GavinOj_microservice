package com.gavin.gavinojbackendquestionservice.service.impl;


import com.Gavin.gavinojbackendmodel.entity.CompetitionQuestion;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gavin.gavinojbackendquestionservice.mapper.CompetitionQuestionMapper;
import com.gavin.gavinojbackendquestionservice.service.CompetitionQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author sms
* @description 针对表【competition_question】的数据库操作Service实现
* @createDate 2024-04-27 16:31:42
*/
@Service
public class CompetitionQuestionServiceImpl extends ServiceImpl<CompetitionQuestionMapper, CompetitionQuestion>
    implements CompetitionQuestionService {

    @Resource
    private CompetitionQuestionMapper competitionQuestionMapper;

    @Override
    public List<Long> selectQuestionIdsByCompetitionId(Long competitionId) {
        return competitionQuestionMapper.selectQuestionIdsByCompetitionId(competitionId);
    }
}




