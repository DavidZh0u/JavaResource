package com.david.service.impl;

import com.david.service.UserService;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Override
    public void getUser() {
        System.out.println("获得一个用户...");
    }
}
