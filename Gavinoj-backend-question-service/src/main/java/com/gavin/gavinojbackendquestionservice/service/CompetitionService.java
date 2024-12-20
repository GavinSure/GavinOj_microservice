package com.gavin.gavinojbackendquestionservice.service;

import com.Gavin.gavinojbackendmodel.entity.Competition;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author sms
* @description 针对表【competition】的数据库操作Service
* @createDate 2024-04-27 14:47:39
*/
public interface CompetitionService extends IService<Competition> {
    //根据当前时间和竞赛的开始时间和结束时间来确定竞赛的状态
    boolean determineCompetitionStatus(Competition competition);


}
