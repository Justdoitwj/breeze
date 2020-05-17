package com.app.breeze.service;

import com.app.breeze.common.pojo.response.CommResponse;
import com.app.breeze.domain.request.UserRequest;

public interface UserService {

    CommResponse login(UserRequest userRequest);

    CommResponse test();

    CommResponse testException();

    CommResponse findUserInfoByAccount(String phone);
}
