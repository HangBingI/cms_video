/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: FilterInvocationSecurityMetadataSource.java@author:
 * jack@date: 2022/10/15 下午6:45@version: 1.0
 */

package com.cms.video.function.common.security;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.cms.video.function.common.constant.SpecialCharactersConstant;
import com.cms.video.function.entity.login.PermissionInfo;
import com.cms.video.function.service.login.LoginService;

/**
 * 安全元数据源
 *
 * @author 14862
 * @date 2022/10/15 18:45
 **/
@Component
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Resource
    LoginService loginService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取请求地址
        String requestUrl = ((FilterInvocation)object).getRequestUrl();
        if (StringUtils.isNotBlank(requestUrl) && requestUrl.contains(SpecialCharactersConstant.QUESTION_MARK)) {
            requestUrl = requestUrl.substring(0, requestUrl.indexOf(SpecialCharactersConstant.QUESTION_MARK));
        }

        // 查询具体某个接口的权限
        List<PermissionInfo> permissionList = loginService.queryPermissionByUrl(requestUrl);
        if (permissionList == null || permissionList.size() == 0) {
            // 请求路径没有配置权限，表明该请求接口可以任意访问
            return null;
        }
        String[] attributes = new String[permissionList.size()];
        for (int i = 0; i < permissionList.size(); i++) {
            attributes[i] = permissionList.get(i).getPermissionCode();
        }
        return SecurityConfig.createList(attributes);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
