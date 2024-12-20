package com.gavin.gavinojbackendjudgeservice.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.Gavin.gavinojbackendmodel.codesandbox.ExecuteCodeResponse;
import com.gavin.Gavinojbackendcommon.common.ErrorCode;
import com.gavin.Gavinojbackendcommon.exception.BusinessException;
import com.gavin.gavinojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: Gavin
 * @description: 远程代码沙箱（调用接口）
 * @className: RemoteCodeSandbox
 * @date: 2024/4/18 21:48
 * @version:0.1
 * @since: jdk14.0
 */
public class RemoteCodeSandbox implements CodeSandbox {
    // 定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://192.168.248.128:8080/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
