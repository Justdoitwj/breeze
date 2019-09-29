package com.app.breeze.service;

import com.app.breeze.comm.pojo.response.BreezeResponse;
import com.app.breeze.web.request.UserRequset;

public interface UserService {

    BreezeResponse login(UserRequset userRequset);

    BreezeResponse test();

    BreezeResponse testException();
}
