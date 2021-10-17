package com.xcy.config;

import com.xcy.Person;
import com.xcy.Student;
import com.xcy.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xcy
 * @Description 使用@Import方式注入 Teacher和Student的bean
 * @date 2021/10/17 1:54
 */
@Configuration
@Import({Teacher.class, Student.class})
public class ImportConfig {

    @Bean
    public Person person01() {
        return new Person("jerry", 18);
    }

    @Bean
    public Person person02() {
        return new Person("tom", 18);
    }
}
