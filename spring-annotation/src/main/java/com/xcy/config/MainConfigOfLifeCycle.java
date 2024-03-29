package com.xcy.config;

import com.xcy.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的生命周期
 * bean 创建--初始化--销毁 的过程
 * bean的生命周期由容器管理
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法。
 *
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 *
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法.
 *
 * 销毁：
 *      单实例：容器关闭的时候进行销毁
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法。
 *
 *
 * 1）、指定初始化和销毁方法
 * 在beans.xml进行配置 init-method="" destroy-method=""
 * 2）、通过Bean实现InitializingBean（定义初始化逻辑），实现DisposableBean（定义销毁逻辑）
 * 3）、可以使用JSR250:
 *      @PostConstruct: 在bean创建完成并且属性赋值完成后执行初始化方法
 *      @PreDestroy: 在容器销毁bean之前通知我们进行清理工作
 * 4)、BeanPostProcessor:bean的后置处理器；
 *      在bean初始化前后进行一些处理工作；
 *      postProcessBeforeInitialization： 在初始化之前工作
 *      postProcessAfterInitialization：  在初始化之后工作
 *
 * @author xcy
 * @Description
 * @date 2021/10/17 20:34
 */
@Configuration
public class MainConfigOfLifeCycle {

    //@Scope(scopeName = "singleton")
    //@Bean(initMethod = "myInit", destroyMethod = "myDestroy")
    //public Car singletonCar() {
    //    return new Car();
    //}

    @Scope(scopeName = "prototype")
    @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
    public Car prototypeCar() {
        return new Car();
    }
}
