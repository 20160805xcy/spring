package com.xcy.bean.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 23:57
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * bean初始化之前执行
     * @param o
     * @param s bean的名字
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + s + " => " + o);
        return o;
    }

    /**
     * bean初始化之后执行
     * @param o
     * @param s bean的名字
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization " + s + " =>" + o);
        return o;
    }
}
