/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: LoginService.java@author: jack@date: 2022/10/15
 * 下午7:32@version: 1.0
 */

package com.cms.video.function.service.login;

import java.util.List;

import com.cms.video.function.entity.login.PermissionInfo;

/**
 * 登录Service层服务
 *
 * @author 14862
 * @date 2022/10/15 19:32
 **/
public interface LoginService {
    /**
     * 根据账号查询权限
     *
     * @param account 账号
     * @return 权限信息集合
     */
    List<PermissionInfo> queryPermissionByAccount(String account);

    /**
     * 根据URL查询请求权限
     * 
     * @param reqUrl 请求URL
     * @return 权限信息集合
     */
    List<PermissionInfo> queryPermissionByUrl(String reqUrl);
}
