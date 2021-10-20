package com.xcy.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author xcy
 * @Description 演示 实现 ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware的作用
 * @date 2021/10/20 22:42
 */
@Component
public class ContextUtils implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    // 从实现 ApplicationContextAware 获取到上下文，并以变量的形式存储起来以便此类到处使用。
    private ApplicationContext applicationContext;

    /**
     * 设置 applicationContext 的 ApplicationContextAware
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("传入的IOC容器    上下文ApplicationContext: " + applicationContext);
    }


    /**
     * 设置 bean 的名字的 BeanNameAware
     * @param name
     */
    public void setBeanName(String name) {
        System.out.println("当前bean的名字： " + name);
    }

    /**
     * 解析字符串
     * @param resolver
     */
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String stringValue = resolver.resolveStringValue("获取到的操作系统名称为：${os.name}; 12乘以3的值为： #{12*3}");
        System.out.println("解析的字符串为： " + stringValue);
    }
}
