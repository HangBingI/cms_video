/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: VideoApplication.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */
package com.cms.video;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author 14862
 * @date 2022/10/15 13:07
 **/
@SpringBootApplication
@MapperScan("com.cms.video.function.dao")
public class VideoApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoApplication.class, args);
    }
}
