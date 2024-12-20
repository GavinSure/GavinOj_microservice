package com.Gavin.gavinojbackendmodel.dto.questionsubmit;


import com.gavin.Gavinojbackendcommon.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author: Gavin
 * @description:
 * @className: QuestionSubmitQueryRequest
 * @date: 2024/4/13 15:00
 * @version:0.1
 * @since: jdk14.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 提交状态
     */
    private Integer status;

    /**
     * 题目 id
     */
    private Long questionId;


    /**
     * 用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
