package com.gavin.gavinojbackendquestionservice.service.impl;


import com.Gavin.gavinojbackendmodel.entity.Competition;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gavin.gavinojbackendquestionservice.mapper.CompetitionMapper;
import com.gavin.gavinojbackendquestionservice.service.CompetitionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author sms
* @description 针对表【competition】的数据库操作Service实现
* @createDate 2024-04-27 14:47:39
*/
@Service
public class CompetitionServiceImpl extends ServiceImpl<CompetitionMapper, Competition>
    implements CompetitionService {

    @Resource
    private CompetitionMapper competitionMapper;

    @Override
    public boolean determineCompetitionStatus(Competition competition) {
        Date currentTime = new Date();
        Date startTime = competition.getStartTime();
        Date endTime = competition.getEndTime();

        if (currentTime.after(startTime) && currentTime.before(endTime)) {
            return true;
        } else {
            return false;
        }
    }

}




