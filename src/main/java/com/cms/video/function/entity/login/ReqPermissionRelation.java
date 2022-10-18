/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: ReqPermissionRelation.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */
package com.cms.video.function.entity.login;

/**
 * 请求路径和权限关联关系信息
 *
 * @author 14862
 * @date 2022/10/15 13:05
 **/
public class ReqPermissionRelation {
    /**
     * 请求路径和权限关联关系ID
     */
    private Integer id;

    /**
     * 请求路径ID
     */
    private Integer reqId;

    /**
     * 权限ID
     */
    private Integer permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
