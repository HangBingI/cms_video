/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: UserInfo.java@author: jack@date: 2022/10/14 下午9:04@version:
 * 1.0
 */
package com.cms.video.function.entity.user;

import java.sql.Date;

/**
 * 用户信息
 *
 * @author 14862
 * @date 2022/10/15 13:06
 **/
public class UserInfo {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 账号
     */
    private String account;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 账号是否可用：0：是 1：否
     */
    private int enable;

    /**
     * 账号是否过期:0：是 1：否
     */
    private int isExpired;

    /**
     * 账号是否锁定：0：是 1：否
     */
    private int accountIsLocked;

    /**
     * 证书密码是否过期：0：是 1：否
     */
    private int credentialsIsExpired;

    /**
     * 账号创建时间
     */
    private Date createTime;

    /**
     * 账号修改时间
     */
    private Date updateTime;

    /**
     * 账号创建人
     */
    private Integer createUser;

    /**
     * 账号修改人
     */
    private Integer updateUser;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(int isExpired) {
        this.isExpired = isExpired;
    }

    public int getAccountIsLocked() {
        return accountIsLocked;
    }

    public void setAccountIsLocked(int accountIsLocked) {
        this.accountIsLocked = accountIsLocked;
    }

    public int getCredentialsIsExpired() {
        return credentialsIsExpired;
    }

    public void setCredentialsIsExpired(int credentialsIsExpired) {
        this.credentialsIsExpired = credentialsIsExpired;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
}
