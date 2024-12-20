package com.gavin.gavinojbackendjudgeservice.judge.codesandbox;


import com.gavin.gavinojbackendjudgeservice.judge.codesandbox.impl.ExampleCodeSandbox;
import com.gavin.gavinojbackendjudgeservice.judge.codesandbox.impl.RemoteCodeSandbox;
import com.gavin.gavinojbackendjudgeservice.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * @author: Gavin
 * @description: 代码沙箱工厂(静态工厂 ）
 * @className: CodeSandboxFactory
 * @date: 2024/4/19 16:38
 * @version:0.1
 * @since: jdk14.0
 */
public class CodeSandboxFactory {

    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
