package com.xcy.config;

import com.xcy.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author xcy
 * @Description scope = prototype 是多例的
 * @date 2021/10/16 20:24
 */
@Configuration
public class MainProtoScopeConfig {

    // 在容器中注册一个bean；类型为返回值的类型；id默认是方法名，如需要修改id则可以在@Bean注解后加入别名即可。
    @Scope("prototype")
    @Bean("personProto")
    public Person person2() {
        return new Person("每次都是新的墨白", 19);
    }
}
