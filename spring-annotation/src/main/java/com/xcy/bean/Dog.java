package com.xcy.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 23:41
 */
@Component
public class Dog {
    public Dog() {
        System.out.println("dog constructor...");
    }

    /**
     * 对象创建并赋值之后调用
     */
    @PostConstruct
    public void myInit() {
        System.out.println("dog @PostConstruct myInit() 执行...");
    }

    /**
     * 容器移除对象之前执行
     */
    @PreDestroy
    public void myDestroy() {
        System.out.println("dog @PreDestroy myDestroy() 执行...");
    }

}
