package com.xcy.bean;

import com.xcy.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author xcy
 * @Description 使用spring提供的FactoryBean创建Student类型的bean
 * @date 2021/10/17 18:45
 */
public class StudentFactoryBean implements FactoryBean<Student> {
    /**
     * 返回一个bean，添加到ioc容器中
     * @return
     * @throws Exception
     */
    public Student getObject() {
        System.out.println("StudentFactoryBean.getObject()执行....");
        return new Student();
    }

    /**
     * 定义返回类型
     * @return 对应bean的类型
     */
    public Class<?> getObjectType() {
        return Student.class;
    }

    /**
     * 控制创建的bean是否是单例
     * @return false：不是单例，是多例；true：是单例
     */
    public boolean isSingleton() {
        //return true;
        return false;
    }
}
