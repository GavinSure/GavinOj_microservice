package com.Gavin.gavinojbackendmodel.dto.question;

import lombok.Data;

/**
 * @author: Gavin
 * @description:
 * @className: JudgeConfig
 * @date: 2024/4/13 14:43
 * @version:0.1
 * @since: jdk14.0
 */
@Data
public class JudgeConfig {


    /*
     * 时间限制(ms)
     * */
    private Long timeLimit;

    //空间限制(kb)
    private Long memoryLimit;

    //堆栈限制(kb)
    private Long stackLimit;
}
