package com.xcy.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xcy
 * @Description 匹配Linux系统
 * @date 2021/10/17 0:43
 */
public class LinuxCondition implements Condition {
    /**
     * @param context  判断条件能使用的上下文（环境）
     * @param metadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1.能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 2.能获取到类加载器
        ClassLoader classLoader = context.getClassLoader();

        // 3.能获取到环境的信息
        Environment environment = context.getEnvironment();

        // 4.能获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Linux")) {
            return true;
        }

        return false;
    }
}
