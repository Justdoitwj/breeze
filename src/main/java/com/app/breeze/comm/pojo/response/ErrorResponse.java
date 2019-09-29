package com.app.breeze.comm.pojo.response;

/**
 * <p>错误返回结果</p>
 *
 * @author wangjie
 * @date 2019/5/2
 */
public class ErrorResponse extends BaseResponse {

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message) {
        super(code, message);
    }
}
