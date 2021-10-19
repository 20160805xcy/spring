package com.xcy;

import com.xcy.config.MainConfigOfAutowired;
import com.xcy.dao.UserDao;
import com.xcy.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description
 * @date 2021/10/18 23:44
 */
public class IOCAutowiredTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);

        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);

        //对比userService里面的userDao和从容器中获取到的userDao,发现是同一个对象。

    }

}
