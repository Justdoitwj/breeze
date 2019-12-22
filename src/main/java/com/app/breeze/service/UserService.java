package com.app.breeze.service;

import com.app.breeze.common.pojo.response.BreezeResponse;
import com.app.breeze.domain.request.UserRequest;

public interface UserService {

    BreezeResponse login(UserRequest userRequest);

    BreezeResponse test();

    BreezeResponse testException();

    BreezeResponse findUserInfoByAccount(String phone);
}
