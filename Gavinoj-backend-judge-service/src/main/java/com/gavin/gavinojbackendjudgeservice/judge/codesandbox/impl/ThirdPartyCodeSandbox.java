package com.gavin.gavinojbackendjudgeservice.judge.codesandbox.impl;


import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeResponse;
import com.gavin.gavinojbackendjudgeservice.judge.codesandbox.CodeSandbox;

/**
 * @author: Gavin
 * @description: 第三方沙箱
 * @className: ThirdPartyCodeSandbox
 * @date: 2024/4/18 21:54
 * @version:0.1
 * @since: jdk14.0
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
