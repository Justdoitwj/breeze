package com.app.breeze.web.controller;

import com.app.breeze.common.pojo.response.BreezeResponse;
import com.app.breeze.domain.request.UserRequest;
import com.app.breeze.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.Callable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
@RestController
@RequestMapping(value = "/v1/user")
@Api(value = "UserLoginWeb", description = "用户登陆相关接口,此url路径不会有权限拦截")
public class UserLoginController {
    @Autowired
    private UserService userService;


    /**
     * 登陆接口
     * 1.判断用户名密码是否正确
     * 2.生成令牌和用户信息返回到前端
     */
    @ApiOperation(value = "用户登陆", httpMethod = "POST",code = 200,produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = { "application/json"})
    //限流 10秒内最多允许1000次访问
//    @Limit(key = "USER:LOGIN", period = 10, count = 1000)
    public Callable<BreezeResponse> login(@RequestBody @Validated UserRequest userInfo) {
        return ()-> userService.login(userInfo);
    }

    @ApiOperation(value = "测试自定义异常", httpMethod = "GET",code = 200,produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/testException",method = RequestMethod.GET, produces = { "application/json"})
    public Callable<BreezeResponse> testException(@RequestBody @Validated UserRequest userInfo) {
        return ()-> userService.testException();
    }


    /**
     * 测试接口
     */
    @ApiOperation(value = "用户登陆", httpMethod = "GET",code = 200,produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Callable<BreezeResponse> test() {
        return ()->userService.test();
    }
    /**
     * 注册接口
     */
    @ApiOperation(value = "用户注册", httpMethod = "POST",code = 200,produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = { "application/json"})
    //默认5秒内同一手机号不可重复提交
//    @PreventResubmitLock(prefix = "USER:REGISTER")
    //cache会在方法执行后缓存,相当于更新了缓存,少了一步查询缓存
    public Callable<BreezeResponse>  register(@RequestBody UserRequest userInfo) {
        return ()-> BreezeResponse.success().setMessage("注册成功");
    }


}
