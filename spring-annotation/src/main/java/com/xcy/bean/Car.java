package com.xcy.bean;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 20:41
 */
public class Car {
    public Car() {
        System.out.println("car constructor 执行...");
    }

    public void myInit() {
        System.out.println("car myInit() 执行...");
    }

    public void myDestroy() {
        System.out.println("car myDestroy() 执行...");
    }
}
