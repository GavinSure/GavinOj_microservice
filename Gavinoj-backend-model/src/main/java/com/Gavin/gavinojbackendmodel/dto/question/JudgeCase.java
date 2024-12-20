package com.Gavin.gavinojbackendmodel.dto.question;

import lombok.Data;

/**
 * @author: Gavin
 * @description: 方便处理输入输出样例中的json
 * @className: JudgeCase
 * @date: 2024/4/13 14:33
 * @version:0.1
 * @since: jdk14.0
 */

@Data
public class JudgeCase {

    //用例输入
    private String input;


    //用例输出
    private String output;
}
