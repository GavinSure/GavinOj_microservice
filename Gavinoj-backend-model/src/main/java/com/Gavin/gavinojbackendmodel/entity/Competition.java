package com.Gavin.gavinojbackendmodel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName competition
 */
@TableName(value ="competition")
@Data
public class Competition implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

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
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}