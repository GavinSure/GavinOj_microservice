package com.gavin.gavinojbackendjudgeservice.judge.codesandbox;


import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Gavin
 * @description: 沙箱代理
 * @className: CodeSandboxProxy
 * @date: 2024/4/19 17:10
 * @version:0.1
 * @since: jdk14.0
 */
@Slf4j
public class CodeSandboxProxy implements CodeSandbox {

    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息：" + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱相应信息：" + executeCodeRequest.toString());
        return codeSandbox.executeCode(executeCodeRequest);
    }
}
