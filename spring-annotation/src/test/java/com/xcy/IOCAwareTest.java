package com.xcy;

import com.xcy.util.ContextUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description 测试各种xxxAware接口的实现类的作用
 * @date 2021/10/18 23:44
 */
public class IOCAwareTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextUtils.class);

        System.out.println("测试方法中获取到的上下文ApplicationContext: " + context);

    }

}
