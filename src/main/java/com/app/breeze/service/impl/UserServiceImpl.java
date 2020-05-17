package com.app.breeze.service.impl;

import com.app.breeze.common.pojo.response.CommResponse;
import com.app.breeze.enums.ResponseEnum;
import com.app.breeze.dao.UserDao;
import com.app.breeze.domain.entity.ControlUser;
import com.app.breeze.domain.request.UserRequest;
import com.app.breeze.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: breeze
 * @PackageName: com.web.breeze.service.impl
 * @ClassName: UserServiceImpl
 * @Description:
 * @author: wangjie
 * @date: 2019/9/24  23:33
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public CommResponse login(UserRequest userRequest) {
        return CommResponse.success().setMessage("登录成功");
    }

    @Override
    public CommResponse test() {
        return CommResponse.success().setMessage("测试个接口");
    }

    @Override
    public CommResponse testException() {
        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(null);
        return CommResponse.success().setMessage("测试个接口");
    }

    @Override
    public CommResponse findUserInfoByAccount(String phone) {
        ControlUser user=userDao.findUserInfoByAccount(phone);
        user.setNICKName("测试不符合驼峰命名的字段是否会被jackjson正常解析！！！");
        user.setTestLong(5454848454512121212L);
        return CommResponse.success().setMessage("用户信息查询成功！").setData(user);
    }

}
