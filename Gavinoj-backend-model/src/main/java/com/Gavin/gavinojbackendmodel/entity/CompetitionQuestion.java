package com.Gavin.gavinojbackendmodel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName competition_question
 */
@TableName(value ="competition_question")
@Data
public class CompetitionQuestion implements Serializable {
    /**
     * 
     */
    @TableId
    private Long competition_id;

    /**
     * 
     */
    private Long question_id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}