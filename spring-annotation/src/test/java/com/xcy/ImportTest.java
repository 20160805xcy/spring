package com.xcy;

import com.xcy.config.ImportConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 1:53
 */
public class ImportTest {

    @Test
    public void getAllBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
