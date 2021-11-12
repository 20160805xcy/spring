package com.xcy.servlet;

import com.xcy.service.HelloService;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author xcy
 * @Description
 * @date 2021/11/11 0:13
 */
// 容器启动时会将@HandlesTypes指定的这个类型下面的子类（实现类，子接口等）传递过来。
// 传入感兴趣的类型
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 应用启动的时候，会运行onStartup方法：
     * @param set            感兴趣的类型的所有子类型；
     * @param servletContext 代表当前Web应用的ServletContext;一个Web应用对应一个ServletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("1111111111111111111111111111111111111S");
        for (Class<?> clazz : set){
            System.out.println("感兴趣的类型： " + clazz);
        }
    }
}
