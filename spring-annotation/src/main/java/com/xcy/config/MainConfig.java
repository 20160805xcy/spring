package com.xcy.config;

import com.xcy.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 * @author xcy
 * @Description
 * @date 2021/10/16 20:24
 */
@Configuration
//@ComponentScan(value = "com.xcy", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Repository.class})
//} )
@ComponentScan(value = "com.xcy", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
public class MainConfig {

    // 在容器中注册一个bean；类型为返回值的类型；id默认是方法名，如需要修改id则可以在@Bean注解后加入别名即可。
    @Bean("personAlias")
    public Person person() {
        return new Person("墨白", 19);
    }

}
