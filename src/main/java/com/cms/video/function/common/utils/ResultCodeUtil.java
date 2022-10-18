/*
 * Copyright (c) 2021-2022 HIA All Rights Reserved.FileName: ResultCodeUtil.java@author: jack@date: 2022/10/14
 * 下午9:04@version: 1.0
 */

package com.cms.video.function.common.utils;

import com.cms.video.function.entity.basic.JsonResult;
import com.cms.video.function.entity.basic.ResultCode;

/**
 * 结果返回工具类
 *
 * @author 14862
 * @date 2022/10/15 12:51
 **/
public class ResultCodeUtil {
    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }
}
