package com.xcy.factory;

import com.xcy.dao.UserDao;
import com.xcy.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @author xcy
 * @Desc 通过反射简单实现spring bean的依赖注入,以及AOP的简单演示
 * @date 2020/7/31 2:32
 * @Version v1.0
 */
public class BeanFactory {
    private static Properties props = new Properties();


    static {
        InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");

        try {
            props.load(inputStream);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("加载beans.properties文件失败");
        }
    }

    public static UserDao getUserDaoImpl() {
        final UserDao userDao;
        UserDao proxyUserDao;
        try {
            String implClassName = props.getProperty("userDao");
            userDao = (UserDao) Class.forName(implClassName).newInstance();
            proxyUserDao = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("Dao层 addUser()方法执行前 doSomethings");
                            Object invoke = method.invoke(userDao, args);
                            System.out.println("Dao层 addUser()方法执行后 doSomethings");
                            return invoke;
                        }
                    }
            );

            System.out.println("创建userDao bean");
        } catch (Exception e) {
            throw new RuntimeException("创建类的实例失败");
        }
        return proxyUserDao;
    }

    public static UserService getUserServiceImpl() {
        final UserService userService;
        UserService proxyUserService;

        try {
            String implClassName = props.getProperty("userService");
            userService = (UserService) Class.forName(implClassName).newInstance();
            proxyUserService = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            long startTime = System.nanoTime();
                            System.out.println("UserService层 addUser()方法执行前 doSomethings");
                            Object invoke = method.invoke(userService, args);
                            System.out.println("UserService层 addUser()方法执行后 doSomethings");
                            long endTime = System.nanoTime();
                            System.out.println("UserService层 addUser()方法执行耗时: " + ((endTime - startTime) / 1000000) + "ms");
                            return invoke;
                        }
                    }
            );

            System.out.println("创建userService bean");
        } catch (Exception e) {
            throw new RuntimeException("创建类的实例失败");
        }
        return proxyUserService;
    }
}
