package com.app.breeze.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by wangjie on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan({"com.app.breeze.dao"})
public class MyBatisConfig {
}
