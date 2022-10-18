/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: CustomizeAuthenticationEntryPoint.java@author: jack@date:
 * 2022/10/15 下午4:53@version: 1.0
 */

package com.cms.video.function.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import com.cms.video.function.common.constant.WebRelatedConstant;
import com.cms.video.function.common.utils.ResultCodeUtil;
import com.cms.video.function.entity.basic.JsonResult;
import com.cms.video.function.entity.basic.ResultCode;

/**
 * 定制登录返回响应信息
 *
 * @author 14862
 * @date 2022/10/15 16:52
 **/
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) throws IOException, ServletException {
        JsonResult result = ResultCodeUtil.fail(ResultCode.USER_NOT_LOGIN);
        response.setContentType(WebRelatedConstant.CONTENT_TYPE);
        response.getWriter().write(JSON.toJSONString(result));

    }
}
