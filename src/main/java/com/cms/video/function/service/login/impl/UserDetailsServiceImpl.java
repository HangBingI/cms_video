/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: UserDetailsServiceImpl.java@author: jack@date: 2022/10/15
 * 下午9:28@version: 1.0
 */

package com.cms.video.function.service.login.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import com.cms.video.function.common.utils.CommonUtil;
import com.cms.video.function.dao.login.LoginDao;
import com.cms.video.function.dao.user.UserDao;
import com.cms.video.function.entity.login.PermissionInfo;
import com.cms.video.function.entity.user.UserInfo;

/**
 * 登录用户认证服务实现类
 *
 * @author 14862
 * @date 2022/10/15 21:27
 **/
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * 用户信息DAO层服务
     */
    @Resource
    private UserDao userDao;

    /**
     * 登录DAO层服务
     */
    @Resource
    private LoginDao loginDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
            throw new RuntimeException("用户名为空.");
        }

        UserInfo userInfo = userDao.queryUserINfoByAccountName(username);
        if (userInfo == null) {
            throw new RuntimeException("用户不存在.");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<PermissionInfo> permissionInfos = loginDao.queryPermissionByAccount(username);
        if (CollectionUtils.isEmpty(permissionInfos)) {
            return new User(userInfo.getAccount(), userInfo.getPassword(),
                CommonUtil.isTrueORFalse(userInfo.getEnable()), CommonUtil.isTrueORFalse(userInfo.getIsExpired()),
                CommonUtil.isTrueORFalse(userInfo.getCredentialsIsExpired()),
                CommonUtil.isTrueORFalse(userInfo.getAccountIsLocked()), grantedAuthorities);
        }

        permissionInfos.stream()
            .forEach(p -> grantedAuthorities.add(new SimpleGrantedAuthority(p.getPermissionCode())));
        return new User(userInfo.getAccount(), userInfo.getPassword(), CommonUtil.isTrueORFalse(userInfo.getEnable()),
            CommonUtil.isTrueORFalse(userInfo.getIsExpired()),
            CommonUtil.isTrueORFalse(userInfo.getCredentialsIsExpired()),
            CommonUtil.isTrueORFalse(userInfo.getAccountIsLocked()), grantedAuthorities);
    }
}
