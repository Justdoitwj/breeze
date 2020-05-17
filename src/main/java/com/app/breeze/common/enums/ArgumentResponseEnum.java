package com.app.breeze.common.enums;

import com.app.breeze.common.exception.assertion.ArgumentExceptionAssert;
import com.app.breeze.common.exception.assertion.CommonExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>参数校验异常返回结果</p>
 *
 * @author wangjie
 * @date 2019/5/2
 */
@Getter
@AllArgsConstructor
public enum ArgumentResponseEnum implements ArgumentExceptionAssert {
    /**
     * 绑定参数校验异常
     */
    VALID_ERROR(6000, "参数校验异常"),

    ;

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回消息
     */
    private String message;

}
