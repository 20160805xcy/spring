package com.xcy.importBeanDefinitionRegistrar;

import com.xcy.Student;
import com.xcy.Teacher;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 17:46
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 通过BeanDefinitionRegistry.registerBeanDefinition()方法将需要添加到ioc容器中的bean手动注册进去
     * @param importingClassMetadata 当前类的注解信息
     * @param registry               BeanDefinitionRegistry注册类
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // Teacher类bean的定义信息
        RootBeanDefinition teacherRootBeanDefinition = new RootBeanDefinition(Teacher.class);
        // 指定bean的名称为teacher
        registry.registerBeanDefinition("teacher", teacherRootBeanDefinition);

        // Student类bean的定义信息
        RootBeanDefinition studentRootBeanDefinition = new RootBeanDefinition(Student.class);
        // 指定bean的名称为student
        registry.registerBeanDefinition("student", studentRootBeanDefinition);
    }
}
