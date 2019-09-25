package com.app.breeze.service;

import com.app.breeze.comm.model.BreezeResponse;
import com.app.breeze.web.request.UserRequset;

public interface UserService {

    BreezeResponse login(UserRequset userRequset);
}
