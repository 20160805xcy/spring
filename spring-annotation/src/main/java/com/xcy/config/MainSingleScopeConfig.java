package com.xcy.config;

import com.xcy.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author xcy
 * @Description 默认是单例模式bean
 * @date 2021/10/16 20:24
 */
@Configuration
public class MainSingleScopeConfig {

    // 不配置则默认就是单例的
    @Scope("singleton")
    // 在容器中注册一个bean；类型为返回值的类型；id默认是方法名，如需要修改id则可以在@Bean注解后加入别名即可。
    @Bean("personSingle")
    public Person person1() {
        return new Person("永远一个实例的墨白", 19);
    }

}
