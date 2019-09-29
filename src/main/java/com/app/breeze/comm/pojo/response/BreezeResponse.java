package com.app.breeze.comm.pojo.response;

import cn.hutool.core.collection.CollectionUtil;
import com.app.breeze.comm.enums.StatusCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collection;

/**
 * @ProjectName: breeze
 * @PackageName: com.web.breeze.comm.pojo
 * @ClassName: BreezeResponse
 * @Description:
 * @author: wangjie
 * @date: 2019/9/24  17:26
 */
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(value = {"valid"})
public class BreezeResponse<T> {
    private boolean success;
    private String message;
    private StatusCode statusCode;
    private T data;

    public BreezeResponse(boolean success, String message) {
        this(success, message, (StatusCode)null, null);
    }

    public BreezeResponse(boolean success, String message, T data) {
        this(success, message, (StatusCode)null, data);
    }


    public BreezeResponse(boolean status, String message, StatusCode statusCode) {
        this(status, message, statusCode, null);
    }
    public BreezeResponse(boolean status, StatusCode statusCode) {
        this(status, null, statusCode, null);
    }


    public BreezeResponse(boolean success, String message, StatusCode statusCode, T data) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
        if (this.success && this.statusCode == null) {
            this.statusCode = StatusCode.SUCCESS;
        }
    }
    public static BreezeResponse success() {
        return new BreezeResponse(true,StatusCode.SUCCESS);
    }

    public static BreezeResponse error() {
        return new BreezeResponse(false,StatusCode.FAIL);
    }

    public static BreezeResponse error(StatusCode statusCode) {
        return new BreezeResponse(false,statusCode);
    }


    public boolean isValid(boolean allowEmpty) {
        if (!this.success) {
            return false;
        } else if (allowEmpty) {
            return true;
        } else if (this.data instanceof Collection) {
            return CollectionUtil.isNotEmpty((Collection)this.data);
        } else {
            return this.data != null;
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public BreezeResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BreezeResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public BreezeResponse setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public T getData() {
        return data;
    }

    public BreezeResponse setData(T data) {
        this.data = data;
        return this;
    }

    protected boolean canEqual(Object other) {
        return other instanceof BreezeResponse;
    }


}
