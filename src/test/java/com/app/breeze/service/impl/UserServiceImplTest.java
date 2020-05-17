package com.app.breeze.service.impl;

import com.app.breeze.common.pojo.response.CommResponse;
import com.app.breeze.enums.ResponseEnum;
import com.app.breeze.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        CommResponse response=userService.findUserInfoByAccount("wj");
        ResponseEnum.DATA_NOT_FOUND.assertNotNull(response.getData());
    }
}