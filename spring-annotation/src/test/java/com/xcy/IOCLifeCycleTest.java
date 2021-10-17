package com.xcy;

import com.xcy.bean.Car;
import com.xcy.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 21:21
 */
public class IOCLifeCycleTest {

    /**
     * 配合单例bean的初始化来进行测试，先将多例的bean注释掉
     */
    @Test
    public void singletonBeanTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("IOC容器创建完成...");
        // 输出所有的bean
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        // 关闭容器
        ((AnnotationConfigApplicationContext) context).close();
    }

    /**
     * 配合多例bean的初始化来进行测试，先将单例的bean注释掉
     */
    @Test
    public void prototypeBeanTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("IOC容器创建完成...");
        // 输出所有的bean
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        // 获取多实例的bean
        Car car = (Car) context.getBean("prototypeCar");
        System.out.println(car);
        // 关闭容器
        ((AnnotationConfigApplicationContext) context).close();
    }
}
