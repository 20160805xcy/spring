package com.xcy.config;

import com.xcy.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @author xcy
 * @Description 懒加载bean配置
 * @date 2021/10/16 20:24
 */
@Configuration
public class MainLazyLoadConfig {

    // 在容器中注册一个bean；类型为返回值的类型；id默认是方法名，如需要修改id则可以在@Bean注解后加入别名即可。
    @Lazy
    @Bean("personLazyLoad")
    public Person person2() {
        System.out.println("给容器中添加bean");
        return new Person("永远一个实例的墨白", 19);
    }
}
