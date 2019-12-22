package com.app.breeze.constant;

import com.app.breeze.common.exception.assertion.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {
    DATA_NOT_FOUND(0000, "查询信息失败"),
    LICENCE_NOT_FOUND(7002, "用户未查询到");

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}
