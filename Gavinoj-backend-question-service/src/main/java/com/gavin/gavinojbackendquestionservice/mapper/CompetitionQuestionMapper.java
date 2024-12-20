package com.gavin.gavinojbackendquestionservice.mapper;


import com.Gavin.gavinojbackendmodel.entity.CompetitionQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author sms
* @description 针对表【competition_question】的数据库操作Mapper
* @createDate 2024-04-27 16:31:42
* @Entity com.Gavin.gavinoj.model.entity.CompetitionQuestion
*/
@Mapper
public interface CompetitionQuestionMapper extends BaseMapper<CompetitionQuestion> {

        List<Long> selectQuestionIdsByCompetitionId(@Param("competitionId") Long competitionId);

}




