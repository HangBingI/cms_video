/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: LoginDao.java@author: jack@date: 2022/10/15 下午7:25@version:
 * 1.0
 */

package com.cms.video.function.dao.login;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.cms.video.function.entity.login.PermissionInfo;

/**
 * 登录DAO层服务
 *
 * @author 14862
 * @date 2022/10/15 19:25
 **/
@Mapper
public interface LoginDao {
    /**
     * 根据账号查询权限
     *
     * @param account 账号
     * @return 权限信息集合
     */
    @Select("SELECT d.* FROM sys_user a,sys_user_role_relation b,sys_role_permission_relation c,sys_permission d WHERE a.id = b.user_id AND b.role_id=c.role_id AND c.permission_id = d.id AND a.account_number=#{account}")
    @Results(id = "permission",
        value = {@Result(property = "permissionId", column = "id"),
            @Result(property = "permissionCode", column = "permission_code"),
            @Result(property = "permissionName", column = "permission_name")})
    List<PermissionInfo> queryPermissionByAccount(@Param("account") String account);
}
