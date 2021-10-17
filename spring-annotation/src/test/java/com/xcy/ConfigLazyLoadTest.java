package com.xcy;

import com.xcy.config.MainLazyLoadConfig;
import com.xcy.config.MainProtoScopeConfig;
import com.xcy.config.MainSingleScopeConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description 懒加载测试
 * @date 2021/10/16 22:35
 */
public class ConfigLazyLoadTest {

    @Test
    public void getSingleBeanTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainLazyLoadConfig.class);
        System.out.println("IOC容器创建完成");

        // 只有当执行具体的获取bean方法时候，才会真正的执行bean的初始化，做到了延迟加载的目的
        Person personSingle = (Person) context.getBean("personLazyLoad");
        System.out.println(personSingle);
    }

}
