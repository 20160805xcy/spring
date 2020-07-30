package com.xcy.dao.impl;

import com.xcy.dao.UserDao;

/**
 * @author xcy
 * @Desc
 * @date 2020/7/31 2:31
 * @Version v1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("调用dao将用户写入到数据库");
    }
}
