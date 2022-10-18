/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: LoginController.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */

package com.cms.video.function.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制类
 *
 * @author 14862
 * @date 2022/10/15 13:02
 **/
@RestController
@RequestMapping("/login")
public class LoginController {
    /**
     * 日志记录
     */
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login.do")
    public String login() {
        return "sssss";
    }
}
