/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: CustomizeAccessDeniedHandler.java@author: jack@date:
 * 2022/10/15 下午5:22@version: 1.0
 */

package com.cms.video.function.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import com.cms.video.function.common.constant.WebRelatedConstant;
import com.cms.video.function.common.utils.ResultCodeUtil;
import com.cms.video.function.entity.basic.JsonResult;
import com.cms.video.function.entity.basic.ResultCode;

/**
 * 定制权限返回响应信息
 *
 * @author 14862
 * @date 2022/10/15 17:22
 **/
@Component
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
        AccessDeniedException accessDeniedException) throws IOException, ServletException {
        JsonResult result = ResultCodeUtil.fail(ResultCode.USER_NOT_LOGIN);
        response.setContentType(WebRelatedConstant.CONTENT_TYPE);
        response.getWriter().write(JSON.toJSONString(result));
    }
}
