package com.mmall.service;

import com.mmall.common.ServierResponse;
import com.mmall.pojo.User;

public interface IUserService {
    ServierResponse<User> login(String username, String password);
}
