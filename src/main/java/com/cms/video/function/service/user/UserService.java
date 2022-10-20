/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: UserService.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */
package com.cms.video.function.service.user;

import com.cms.video.function.entity.user.UserInfo;

/**
 * 用户信息service层接口
 *
 * @author 14862
 * @date 2022/10/15 13:06
 **/
public interface UserService {
    /**
     * 通过用户账号查询用户信息
     *
     * @param account 账号
     * @return 用户信息
     */
    UserInfo queryUserINfoByAccountName(String account);

    /**
     * 修改用户信息
     *
     * @param userInfo 用户信息
     */
    void updateUserInfo(UserInfo userInfo);
}
