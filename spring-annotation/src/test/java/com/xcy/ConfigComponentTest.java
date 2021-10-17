package com.xcy;

import com.xcy.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description
 * @date 2021/10/16 21:09
 */
public class ConfigComponentTest {

    @Test
    public void getBeanByComponentScanTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
