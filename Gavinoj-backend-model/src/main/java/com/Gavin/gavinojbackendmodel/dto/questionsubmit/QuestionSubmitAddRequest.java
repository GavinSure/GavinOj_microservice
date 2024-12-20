package com.Gavin.gavinojbackendmodel.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Gavin
 * @description:
 * @className: QuestionSubmitAddRequest
 * @date: 2024/4/13 14:59
 * @version:0.1
 * @since: jdk14.0
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {
    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;

    /**
     * 题目 id
     */
    private Long questionId;

    private static final long serialVersionUID = 1L;

}
