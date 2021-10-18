package com.xcy.config;

import com.xcy.bean.Pig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xcy
 * @Description 使用@PropertySource读取外部配置文件的k/v值保存到运行环境中
 * @date 2021/10/18 22:42
 */
@PropertySource(value = {"classpath:/pig.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Pig pig() {
        return new Pig();
    }

}
