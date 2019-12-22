package com.app.breeze.service.impl;

import com.app.breeze.common.pojo.response.BreezeResponse;
import com.app.breeze.constant.ResponseEnum;
import com.app.breeze.dao.UserDao;
import com.app.breeze.domain.entity.ControlUser;
import com.app.breeze.domain.request.UserRequest;
import com.app.breeze.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    UserDao userDao;
    @Override
    public BreezeResponse login(UserRequest userRequest) {
        return null;
    }

    @Override
    public BreezeResponse test() {
        return BreezeResponse.success().setMessage("测试个接口");
    }

    @Override
    public BreezeResponse testException() {
        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(null);
        return BreezeResponse.success().setMessage("测试个接口");
    }

    @Override
    public BreezeResponse findUserInfoByAccount(String phone) {
        ControlUser user=userDao.findUserInfoByAccount(phone);
        return BreezeResponse.success().setMessage("用户信息查询成功！").setData(user);
    }

}
