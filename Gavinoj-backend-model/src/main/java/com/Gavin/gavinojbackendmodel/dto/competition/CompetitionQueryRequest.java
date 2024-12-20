package com.Gavin.gavinojbackendmodel.dto.competition;


import com.gavin.Gavinojbackendcommon.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Gavin
 * @description:
 * @className: CompetitionQueryRequest
 * @date: 2024/4/27 16:00
 * @version:0.1
 * @since: jdk14.0
 */


@EqualsAndHashCode(callSuper = true)
@Data
public class CompetitionQueryRequest extends PageRequest implements Serializable {
    /**
     * 竞赛名称
     */
    private String name;

    /**
     * 竞赛开始时间
     */
    private Date startTime;

    /**
     * 竞赛结束时间
     */
    private Date endTime;

    /**
     * 当前竞赛是否被激活
     */
    private boolean status;

}
