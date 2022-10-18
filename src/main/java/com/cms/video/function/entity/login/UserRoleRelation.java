/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: UserRoleRelation.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */
package com.cms.video.function.entity.login;

/**
 * 用户和角色关联关系信息
 *
 * @author 14862
 * @date 2022/10/15 12:29
 **/
public class UserRoleRelation {
    /**
     * 用户和角色关联关系ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    /**
     * @param null
     * @return
     * @author 14862
     * @date 2022/10/15 12:45
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
