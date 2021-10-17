package com.xcy;

import com.xcy.config.MainProtoScopeConfig;
import com.xcy.config.MainSingleScopeConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description 单例和多例测试
 * @date 2021/10/16 22:35
 */
public class ConfigScopeTest {

    @Test
    public void getSingleBeanTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainSingleScopeConfig.class);
        Person personSingle01 = (Person) context.getBean("personSingle");
        Person personSingle02 = (Person) context.getBean("personSingle");
        System.out.println(personSingle01 == personSingle02);
    }


    @Test
    public void getProtoBeanTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainProtoScopeConfig.class);
        Person personSingle01 = (Person) context.getBean("personProto");
        Person personSingle02 = (Person) context.getBean("personProto");
        System.out.println(personSingle01 == personSingle02);
    }
}
