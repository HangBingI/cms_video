/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: RolePermissionRelation.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */
package com.cms.video.function.entity.login;

/**
 * 角色与权限关联关系信息
 *
 * @author 14862
 * @date 2022/10/15 13:05
 **/
public class RolePermissionRelation {
    /**
     * 角色与权限关联关系ID
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 权限ID
     */
    private Integer permissionID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
    }
}
