/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: CustomizeSessionInformationExpiredStrategy.java@author:
 * jack@date: 2022/10/15 下午6:17@version: 1.0
 */

package com.cms.video.function.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import com.cms.video.function.common.utils.ResultCodeUtil;
import com.cms.video.function.entity.basic.JsonResult;
import com.cms.video.function.entity.basic.ResultCode;

/**
 * 会话信息过期策略
 *
 * @author 14862
 * @date 2022/10/15 18:17
 **/
@Component
public class CustomizeSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        JsonResult result = ResultCodeUtil.fail(ResultCode.USER_ACCOUNT_USE_BY_OTHERS);
        HttpServletResponse response = event.getResponse();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
