package com.app.breeze.service.impl;

import cn.hutool.core.lang.Assert;
import com.app.breeze.common.pojo.response.BreezeResponse;
import com.app.breeze.constant.ResponseEnum;
import com.app.breeze.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void login() {
    }

    @Test
    public void test1() {
    }

    @Test
    public void testException() {
    }

    @Test
    public void findUserInfoByAccount() {
        //测试查询
        BreezeResponse response=userService.findUserInfoByAccount("wj");
        ResponseEnum.DATA_NOT_FOUND.assertNotNull(response.getData());
    }
}