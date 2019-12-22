package com.app.breeze.domain.request;

import com.app.breeze.common.annotation.validate.Email;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ProjectName: breeze
 * @PackageName: com.web.breeze.web.request
 * @ClassName: UserRequest
 * @Description:
 * @author: wangjie
 * @date: 2019/9/24  16:23
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 */
/*
 * @Data注解的作用：
 * 所有属性的get和set方法
 * toString 方法
 * hashCode方法
 * equals方法
 */
@Data
@Accessors(chain = true)
public class UserRequest {
    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "手机号码不能为空")
    @Pattern(regexp="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$",message = "手机号码格式不正确")
    private String phoneNum;
    @Email
    private String email;
}
