/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: UserServiceImpl.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */
package com.cms.video.function.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.video.function.dao.user.UserDao;
import com.cms.video.function.entity.user.UserInfo;
import com.cms.video.function.service.user.UserService;

/**
 * 用户信息service实现类
 *
 * @author 14862
 * @date 2022/10/15 13:06
 **/
@Service
public class UserServiceImpl implements UserService {
    /**
     * 用户信息DAO层服务
     */
    @Resource
    private UserDao userDao;

    @Override
    public UserInfo queryUserINfoByAccountName(String account) {
        return userDao.queryUserINfoByAccountName(account);
    }
}
