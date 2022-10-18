/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: UserInfoController.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */

package com.cms.video.function.controller.user;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.video.function.entity.user.UserInfo;
import com.cms.video.function.service.user.UserService;

/**
 * 用户信息控制类
 *
 * @author 14862
 * @date 2022/10/15 13:02
 **/
@RestController
@RequestMapping("/user")
public class UserInfoController {
    /**
     * 日志记录
     */
    private Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    /**
     * 用户信息service服务
     */
    @Resource
    private UserService userService;

    @RequestMapping("/getUser.do")
    public UserInfo getUser(String account) {
        logger.info("Query UserInfo, account=", account);
        UserInfo userInfo = userService.queryUserINfoByAccountName(account);
        logger.info("Query UserInfo, User=", userInfo);
        return userInfo;
    }
}
