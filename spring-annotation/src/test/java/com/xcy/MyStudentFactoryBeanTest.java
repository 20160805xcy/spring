package com.xcy;

import com.xcy.bean.StudentFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 11:47
 */
public class MyStudentFactoryBeanTest {

    @Test
    public void ImportSelectorTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentFactoryBean.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

        // 输出 studentFactoryBean 的bean

        // 看下 studentFactoryBean 对应的类型
        Object studentFactoryBean1 = context.getBean("studentFactoryBean");
        System.out.println("studentFactoryBean1 的类型是： " + studentFactoryBean1.getClass());

        // 通过返回值的类型 为 class com.xcy.Student，可知FactoryBean 获取的是调用getObject创建的对象，
        // 并不是StudentFactoryBean类型

        // 测试bean的单例和多例
        Object studentFactoryBean2 = context.getBean("studentFactoryBean");
        System.out.println(studentFactoryBean1 == studentFactoryBean2);

        // 在bean的id前面加上 & 来获取factoryBean本身
        Object studentFactoryBean3 = context.getBean("&studentFactoryBean");
        System.out.println(studentFactoryBean3);
    }
}
