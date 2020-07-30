package com.xcy.test;

import com.xcy.A;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xcy
 * @Desc
 * @date 2020/7/30 21:10
 * @Version v1.0
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        A a = (A) ac.getBean("A");

        System.out.println(a.getName());
    }
}
