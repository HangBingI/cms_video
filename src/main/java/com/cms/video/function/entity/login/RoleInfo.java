/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: RoleInfo.java@author: jack@date: 2022/10/14 下午9:04@version:
 * 1.0
 */
package com.cms.video.function.entity.login;

/**
 * 角色信息
 *
 * @author 14862
 * @date 2022/10/15 13:05
 **/
public class RoleInfo {
    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
