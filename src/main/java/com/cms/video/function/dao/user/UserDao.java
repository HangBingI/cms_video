/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: UserDao.java@author: jack@date: 2022/10/14 下午9:04@version:
 * 1.0
 */

package com.cms.video.function.dao.user;

import org.apache.ibatis.annotations.*;

import com.cms.video.function.entity.user.UserInfo;

/**
 * 用户信息DAO层服务
 *
 * @author 14862
 * @date 2022/10/15 13:03
 **/
@Mapper
public interface UserDao {
    /**
     * 通过用户账号查询用户信息
     *
     * @param account 账号
     * @return 用户信息
     */
    @Select("select * from sys_user where account_number=#{account}")
    @Results(id = "user",
        value = {@Result(property = "userId", column = "id"), @Result(property = "account", column = "account_number"),
            @Result(property = "userName", column = "user_name"), @Result(property = "password", column = "pwd"),
            @Result(property = "lastLoginTime", column = "last_login_time"),
            @Result(property = "enable", column = "enabled"), @Result(property = "isExpired", column = "is_expired"),
            @Result(property = "accountIsLocked", column = "account_is_locked"),
            @Result(property = "credentialsIsExpired", column = "credentials_is_expired"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createUser", column = "create_user"),
            @Result(property = "updateUser", column = "update_user")})
    UserInfo queryUserINfoByAccountName(@Param("account") String account);
}
