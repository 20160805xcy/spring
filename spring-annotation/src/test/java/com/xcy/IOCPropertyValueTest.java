package com.xcy;

import com.xcy.bean.Pig;
import com.xcy.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 21:21
 */
public class IOCPropertyValueTest {

    @Test
    public void PropertyValueTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("IOC容器创建完成...");
        // 输出所有的bean
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        // 获取多实例的bean
        Pig pig = (Pig) context.getBean("pig");
        System.out.println(pig);

        Environment environment = context.getEnvironment();
        String property = environment.getProperty("pig.weight");
        System.out.println(property);

        // 关闭容器
        ((AnnotationConfigApplicationContext) context).close();
    }
}
