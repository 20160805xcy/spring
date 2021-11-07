package com.xcy.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description 测试各种xxxAware接口的实现类的作用
 * @date 2021/10/18 23:44
 */
public class IOCAOPTest {

    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        // 不要自己new对象，不然对象调用方法时候，aop无法拦截到。
        //MathCalculator mathCalculator = new MathCalculator();
        //int div = mathCalculator.div(10, 5);

        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        mathCalculator.div(10, 5);

        System.out.println("==================测试异常===========================");
        mathCalculator.div(1, 0);


        System.out.println("测试方法中获取到的上下文ApplicationContext: " + context);

    }

}
