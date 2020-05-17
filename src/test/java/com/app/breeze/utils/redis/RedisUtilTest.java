package com.app.breeze.utils.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void hasKey() {
    }

    @Test
    public void expire() {
    }

    @Test
    public void set() {
    }

    @Test
    public void get() {
        redisUtil.set("test","11111111111");
        System.out.println(redisUtil.get("test"));
    }
}