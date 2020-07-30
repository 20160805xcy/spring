package com.xcy.controller;

import com.xcy.factory.BeanFactory;
import com.xcy.service.UserService;

/**
 * @author xcy
 * @Desc
 * @date 2020/7/31 2:30
 * @Version v1.0
 */
public class UserController {
    public static void main(String[] args) {
        UserService userServiceImpl = BeanFactory.getUserServiceImpl();
        userServiceImpl.addUser();
    }
}
