package com.xcy.config;

import com.xcy.bean.StudentFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xcy
 * @Description 使用StudentFactoryBean创建Student的bean
 * @date 2021/10/17 18:50
 */
@Configuration
public class FactoryBeanConfig {

    @Bean
    public StudentFactoryBean studentFactoryBean() {
        return new StudentFactoryBean();
    }
}
