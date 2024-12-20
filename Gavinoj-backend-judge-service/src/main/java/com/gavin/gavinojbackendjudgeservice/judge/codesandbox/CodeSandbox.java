package com.gavin.gavinojbackendjudgeservice.judge.codesandbox;


import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
