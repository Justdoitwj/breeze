package com.app.breeze.service.impl;

import com.app.breeze.comm.pojo.response.BreezeResponse;
import com.app.breeze.constant.ResponseEnum;
import com.app.breeze.service.UserService;
import com.app.breeze.web.request.UserRequset;
import lombok.extern.slf4j.Slf4j;
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
    @Override
    public BreezeResponse login(UserRequset userRequset) {
        return null;
    }

    @Override
    public BreezeResponse test() {
        log.info("测试接口");
        return BreezeResponse.success().setMessage("测试个接口");
    }

    @Override
    public BreezeResponse testException() {
        log.info("测试接口");
        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(null);
        return BreezeResponse.success().setMessage("测试个接口");
    }
}
