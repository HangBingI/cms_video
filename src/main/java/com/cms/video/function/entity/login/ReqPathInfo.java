/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: ReqPathInfo.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */
package com.cms.video.function.entity.login;

/**
 * 请求路径信息
 *
 * @author 14862
 * @date 2022/10/15 13:04
 **/
public class ReqPathInfo {
    /**
     * 请求路径ID
     */
    private Integer reqPathID;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 请求路径描述
     */
    private String urlDesc;

    public Integer getReqPathID() {
        return reqPathID;
    }

    public void setReqPathID(Integer reqPathID) {
        this.reqPathID = reqPathID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlDesc() {
        return urlDesc;
    }

    public void setUrlDesc(String urlDesc) {
        this.urlDesc = urlDesc;
    }
}
