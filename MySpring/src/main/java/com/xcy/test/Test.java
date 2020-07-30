package com.xcy.test;

import com.xcy.A;
import com.xcy.B;
import com.xcy.C;
import com.xcy.config.Bean;
import com.xcy.config.parse.ConfigManager;
import com.xcy.main.BeanFactory;
import com.xcy.main.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author xcy
 * @Desc
 * @date 2020/7/30 22:49
 * @Version v1.0
 */
public class Test {

    //测试解析配置文件
    @org.junit.Test
    public void fun1() {
        Map<String, Bean> config = ConfigManager.getConfig("/myApplicationContext.xml");
        System.out.println(config);
    }

    //测试普通属性
    @org.junit.Test
    public void testValue() {
        BeanFactory bf = new ClassPathXmlApplicationContext("/myApplicationContext.xml");
        A a = (A) bf.getBean("A");
        System.out.println(a.getName());
    }

    //测试引用类型属性
    @org.junit.Test
    public void testRefValue() {
        BeanFactory bf = new ClassPathXmlApplicationContext("/myApplicationContext.xml");
        B b = (B) bf.getBean("B");
        System.out.println(b.getA().getName());
    }

    //测试多重引用
    @org.junit.Test
    public void testMany() {
        BeanFactory bf = new ClassPathXmlApplicationContext("/myApplicationContext.xml");
        C c = (C) bf.getBean("C");
        System.out.println(c.getB().getA().getName());
    }
}
