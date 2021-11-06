package com.xcy;

import com.xcy.config.MainConfigOfProfile;
import com.xcy.util.ContextUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author xcy
 * @Description 测试各种xxxAware接口的实现类的作用
 * @date 2021/10/18 23:44
 */
public class IOCProfileTest {

    /*
        切换环境标识方法：
        1、使用命令行动态参数：在虚拟机参数位置加载 -Dspring.profiles.active=prod
        2、使用代码配置方式

     */

    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }

        System.out.println("测试方法中获取到的上下文ApplicationContext: " + context);

    }

    @Test
    public void test02() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 方式2，使用代码配置方式设置环境
        context.getEnvironment().setActiveProfiles("test", "dev");
        // 注册主配置类
        context.register(MainConfigOfProfile.class);
        // 启动刷新容器
        context.refresh();

        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }

        System.out.println("测试方法中获取到的上下文ApplicationContext: " + context);

    }

}
