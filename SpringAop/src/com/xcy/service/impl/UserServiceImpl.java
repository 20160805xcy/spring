package com.xcy.service.impl;

import com.xcy.dao.UserDao;
import com.xcy.factory.BeanFactory;
import com.xcy.service.UserService;

/**
 * @author xcy
 * @Desc
 * @date 2020/7/31 2:33
 * @Version v1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        UserDao userDao = BeanFactory.getUserDaoImpl();
        userDao.addUser();
    }
}