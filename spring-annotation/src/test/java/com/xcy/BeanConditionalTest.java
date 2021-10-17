package com.xcy;

import com.xcy.config.CreateBeanByConditionConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 0:19
 */
public class BeanConditionalTest {

    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CreateBeanByConditionConfig.class);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
}
