/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: LoginServiceImpl.java@author: jack@date: 2022/10/15
 * 下午7:34@version: 1.0
 */

package com.cms.video.function.service.login.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.video.function.dao.login.LoginDao;
import com.cms.video.function.entity.login.PermissionInfo;
import com.cms.video.function.service.login.LoginService;

/**
 * 登录Service层服务实现类
 *
 * @author 14862
 * @date 2022/10/15 19:33
 **/
@Service
public class LoginServiceImpl implements LoginService {
    /**
     * 登录DAO层服务
     */
    @Resource
    private LoginDao loginDao;

    @Override
    public List<PermissionInfo> queryPermissionByAccount(String account) {
        return loginDao.queryPermissionByAccount(account);
    }

    @Override
    public List<PermissionInfo> queryPermissionByUrl(String reqUrl) {
        return loginDao.queryPermissionByUrl(reqUrl);
    }
}
