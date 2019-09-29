package com.app.breeze.constant;

import com.app.breeze.comm.exception.assertion.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {
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
