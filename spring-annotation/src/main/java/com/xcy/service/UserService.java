package com.xcy.service;

import com.xcy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xcy
 * @Description
 * @date 2021/10/16 21:02
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void print(){
        System.out.println(userDao);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                '}';
    }
}
