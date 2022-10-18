/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: CustomizeAuthenticationSuccessHandler.java@author:
 * jack@date: 2022/10/15 下午6:28@version: 1.0
 */

package com.cms.video.function.common.security;

import java.io.IOException;
import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import com.cms.video.function.common.utils.ResultCodeUtil;
import com.cms.video.function.entity.basic.JsonResult;
import com.cms.video.function.entity.user.UserInfo;
import com.cms.video.function.service.user.UserService;

/**
 * 登录成功处理逻辑
 *
 * @author 14862
 * @date 2022/10/15 18:28
 **/
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    /**
     * 用户信息service服务
     */
    @Resource
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {
        // 更新用户表上次登录时间、更新人、更新时间等字段
        User userDetails = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo = userService.queryUserINfoByAccountName(userDetails.getUsername());
        userInfo.setLastLoginTime(new Date(new java.util.Date().getTime()));
        userInfo.setUpdateTime(new Date(new java.util.Date().getTime()));
        userInfo.setUpdateUser(userInfo.getUserId());
        // userInfo.update(sysUser);

        // 此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        // 进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展

        // 返回json数据
        JsonResult result = ResultCodeUtil.success();
        // 处理编码方式，防止中文乱码的情况
        response.setContentType("text/json;charset=utf-8");
        // 塞到HttpServletResponse中返回给前台
        response.getWriter().write(JSON.toJSONString(result));
    }
}
