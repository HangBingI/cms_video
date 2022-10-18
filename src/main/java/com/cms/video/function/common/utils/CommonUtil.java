/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: CommonUtil.java@author: jack@date: 2022/10/15
 * 下午9:49@version: 1.0
 */

package com.cms.video.function.common.utils;

/**
 * 公共工具类
 *
 * @author 14862
 * @date 2022/10/15 21:49
 **/
public class CommonUtil {
    /**
     * 1：表示是
     */
    private static final Integer YES_NUMBER = 1;

    /**
     * 获取判断参数的Boolean值S
     *
     * @param param 表示是否参数
     * @return
     */
    public static boolean isTrueORFalse(Integer param) {
        if (YES_NUMBER.equals(param)) {
            return true;
        }
        return false;
    }
}
