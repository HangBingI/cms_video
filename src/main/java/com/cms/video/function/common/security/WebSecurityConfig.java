/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: WebsSecurityConfigFilter.java@author: jack@date: 2022/10/15
 * 下午4:39@version: 1.0
 */

package com.cms.video.function.common.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.cms.video.function.service.login.impl.UserDetailsServiceImpl;

/**
 * 菜单权限控制
 *
 * @author 14862
 * @date 2022/10/15 13:01
 **/
@Configurable
@EnableWebSecurity
public class WebSecurityConfig {
    /**
     * 登录成功处理逻辑
     */
    @Resource
    private CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * 登录失败处理逻辑
     */
    @Resource
    private CustomizeAuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 权限拒绝处理逻辑
     */
    @Resource
    private CustomizeAccessDeniedHandler accessDeniedHandler;

    /**
     * 匿名用户访问无权限资源时的异常
     */
    @Resource
    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 会话失效(账号被挤下线)处理逻辑
     */
    @Resource
    private CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    /**
     * 登出成功处理逻辑
     */
    @Resource
    private CustomizeLogoutSuccessHandler logoutSuccessHandler;

    /**
     * 访问决策管理器
     */
    @Resource
    private CustomizeAccessDecisionManager accessDecisionManager;

    /**
     * 实现权限拦截
     */
    @Resource
    private CustomizeFilterInvocationSecurityMetadataSource securityMetadataSource;

    @Resource
    private CustomizeAbstractSecurityInterceptor securityInterceptor;

    @Bean
    public UserDetailsService userDetailsService() {
        // 获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable();
        httpSecurity.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setAccessDecisionManager(accessDecisionManager);// 决策管理器
                o.setSecurityMetadataSource(securityMetadataSource);// 安全元数据源
                return o;
            }
        }).and().
        // 允许所有用户登出
            logout().permitAll().
            // 登出成功处理逻辑
            logoutSuccessHandler(logoutSuccessHandler).
            // 登出之后删除cookie
            deleteCookies("JSESSIONID").
            // 允许所有用户登入
            and().formLogin().permitAll().
            // 登录成功处理逻辑
            successHandler(authenticationSuccessHandler).
            // 登录失败处理逻辑
            failureHandler(authenticationFailureHandler).
            // 异常处理(权限拒绝、登录失效等)
            and().exceptionHandling().
            // 权限拒绝处理逻辑
            accessDeniedHandler(accessDeniedHandler).
            // 匿名用户访问无权限资源时的异常处理
            authenticationEntryPoint(authenticationEntryPoint).
            // 会话管理
            and().sessionManagement().
            // 同一账号同时登录最大用户数
            maximumSessions(1).
            // 会话失效(账号被挤下线)处理逻辑
            expiredSessionStrategy(sessionInformationExpiredStrategy);
        httpSecurity.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
        return httpSecurity.build();
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456admin"));
    }
}
