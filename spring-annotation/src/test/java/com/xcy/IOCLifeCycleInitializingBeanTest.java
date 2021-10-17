package com.xcy;

import com.xcy.config.IOCInitializingBeanConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 22:46
 */
public class IOCLifeCycleInitializingBeanTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(IOCInitializingBeanConfig.class);

        System.out.println("容器创建完成...");

        ((AnnotationConfigApplicationContext) context).close();

    }
}
