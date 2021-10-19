package com.xcy.dao;

import org.springframework.stereotype.Repository;

/**
 * @author xcy
 * @Description
 * @date 2021/10/16 21:02
 */
// 名字默认是类名首字母小写
@Repository
public class UserDao {

    private String label = "通过@Repository注解注入的 userDao bean, id = userDao";

    public String getLabel() {
        return label;
    }

    public void setLabel(String lable) {
        this.label= label;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
