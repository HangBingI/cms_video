/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: PermissionInfo.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */

package com.cms.video.function.entity.login;

/**
 * 权限信息
 *
 * @author 14862
 * @date 2022/10/15 13:04
 **/
public class PermissionInfo {
    /**
     * 权限ID
     */
    private Integer permissionId;

    /**
     * 权限code
     */
    private String permissionCode;

    /**
     * 权限名称
     */
    private String permissionName;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
