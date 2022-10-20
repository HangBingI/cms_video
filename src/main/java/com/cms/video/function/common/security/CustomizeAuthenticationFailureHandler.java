/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: CustomizeAuthenticationFailureHandler.java@author:
 * jack@date: 2022/10/15 下午6:24@version: 1.0
 */

package com.cms.video.function.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import com.cms.video.function.common.constant.WebRelatedConstant;
import com.cms.video.function.common.utils.ResultCodeUtil;
import com.cms.video.function.entity.basic.JsonResult;
import com.cms.video.function.entity.basic.ResultCode;

/**
 * 定制登录失败处理逻辑
 *
 * @author 14862
 * @date 2022/10/15 18:24
 **/
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException exception) throws IOException, ServletException {
        // 返回json数据
        JsonResult result = null;
        if (exception instanceof AccountExpiredException) {
            // 账号过期
            result = ResultCodeUtil.fail(ResultCode.USER_ACCOUNT_EXPIRED);
        } else if (exception instanceof BadCredentialsException) {
            // 密码错误
            result = ResultCodeUtil.fail(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (exception instanceof CredentialsExpiredException) {
            // 密码过期
            result = ResultCodeUtil.fail(ResultCode.USER_CREDENTIALS_EXPIRED);
        } else if (exception instanceof DisabledException) {
            // 账号不可用
            result = ResultCodeUtil.fail(ResultCode.USER_ACCOUNT_DISABLE);
        } else if (exception instanceof LockedException) {
            // 账号锁定
            result = ResultCodeUtil.fail(ResultCode.USER_ACCOUNT_LOCKED);
        } else if (exception instanceof InternalAuthenticationServiceException) {
            // 用户不存在
            result = ResultCodeUtil.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        } else {
            // 其他错误
            result = ResultCodeUtil.fail(ResultCode.COMMON_FAIL);
        }
        // 处理编码方式，防止中文乱码的情况
        response.setContentType(WebRelatedConstant.CONTENT_TYPE);
        // 塞到HttpServletResponse中返回给前台
        response.getWriter().write(JSON.toJSONString(result));
    }
}
