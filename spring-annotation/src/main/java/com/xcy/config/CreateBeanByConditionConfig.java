package com.xcy.config;

import com.xcy.Person;
import com.xcy.condition.LinuxCondition;
import com.xcy.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 0:15
 */
@Configuration
public class CreateBeanByConditionConfig {

    @Conditional({WindowsCondition.class})
    @Bean("WindowsFather")
    public Person personWu() {
        return new Person("Steven", 100);
    }

    @Conditional({LinuxCondition.class})
    @Bean("LinuxFather")
    public Person personCao() {
        return new Person("Linux", 120);
    }
}
