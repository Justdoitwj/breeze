package com.app.breeze.common.pojo.response;

import cn.hutool.core.collection.CollectionUtil;
import com.app.breeze.common.enums.CommResEnum;
import com.app.breeze.common.enums.IResponseEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.Collection;

/**
 * @ProjectName: breeze
 * @PackageName: com.web.breeze.common.pojo
 * @ClassName: CommResponse
 * @Description:
 * @author: wangjie
 * @date: 2019/9/24  17:26
 */
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(value = {"valid"})
public class CommResponse<T> {
    private boolean success;
    private String message;
    private Integer statusCode;
    private String path;
    private Instant timestamp;
    private T data;

    public CommResponse(boolean success, String message) {
        this(success, message, null, null);
    }

    public CommResponse(boolean success, String message, T data) {
        this(success, message, null, data);
    }


    public CommResponse(boolean status, String message, IResponseEnum resEnum) {
        this(status, message, resEnum, null);
    }
    public CommResponse(boolean status, IResponseEnum resEnum) {
        this(status, null, resEnum, null);
    }


    public CommResponse(boolean success, String message, IResponseEnum resEnum, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = Instant.now();
        if (this.success && resEnum == null) {
            this.statusCode = CommResEnum.SUCCESS.getCode();
        }
    }
    public static CommResponse success() {
        return new CommResponse(true,CommResEnum.SUCCESS);
    }

    public static CommResponse error() {
        return new CommResponse(false,CommResEnum.SUCCESS);
    }

    public static CommResponse error(IResponseEnum resEnum) {
        return new CommResponse(false,resEnum);
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

    public CommResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public CommResponse setStatusCode(IResponseEnum resEnum) {
        this.statusCode = resEnum.getCode();
        return this;
    }

    public T getData() {
        return data;
    }

    public CommResponse setData(T data) {
        this.data = data;
        return this;
    }

    protected boolean canEqual(Object other) {
        return other instanceof CommResponse;
    }


}
