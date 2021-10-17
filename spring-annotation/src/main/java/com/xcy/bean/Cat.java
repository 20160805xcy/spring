package com.xcy.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author xcy
 * @Description 创建cat类的bean，并实现InitializingBean, DisposableBean接口
 * @date 2021/10/17 22:40
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat constructor 执行...");
    }

    /**
     * 在bean创建完成，属性赋值完成后进行执行
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet() 执行...");
    }

    /**
     * 单例bean在销毁时候进行执行
     * @throws Exception
     */
    public void destroy() throws Exception {
        System.out.println("cat destroy() 执行...");
    }
}
