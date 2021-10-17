package com.xcy;

import com.xcy.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description
 * @date 2021/10/16 20:26
 */
public class ConfigMainTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }

        // 通过类型获取bean
        Person peronByBeanType = applicationContext.getBean(Person.class);
        System.out.println(peronByBeanType);

        // 通过beanId获取bean
        Person personByBeanId = (Person) applicationContext.getBean("personAlias");
        System.out.println(personByBeanId);



    }
}
