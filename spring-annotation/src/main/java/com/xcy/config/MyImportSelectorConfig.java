package com.xcy.config;

import com.xcy.Person;
import com.xcy.condition.LinuxCondition;
import com.xcy.condition.WindowsCondition;
import com.xcy.importSelector.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xcy
 * @Description 使用ImportSelector导入自定义组件
 * @date 2021/10/17 0:15
 */
@Configuration
@Import({MyImportSelector.class})
public class MyImportSelectorConfig {

    @Bean("WindowsFather")
    public Person personWu() {
        return new Person("Steven", 100);
    }

    @Bean("LinuxFather")
    public Person personCao() {
        return new Person("Linux", 120);
    }
}
