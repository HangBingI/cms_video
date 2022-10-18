/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: CustomizeLogoutSuccessHandler.java@author: jack@date:
 * 2022/10/15 下午6:21@version: 1.0
 */

package com.cms.video.function.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import com.cms.video.function.common.utils.ResultCodeUtil;
import com.cms.video.function.entity.basic.JsonResult;

/**
 * 定制登出成功策略
 *
 * @author 14862
 * @date 2022/10/15 18:20
 **/
@Component
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException {
        JsonResult result = ResultCodeUtil.success();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
