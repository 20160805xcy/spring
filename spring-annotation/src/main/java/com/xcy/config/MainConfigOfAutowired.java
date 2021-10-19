package com.xcy.config;

import com.xcy.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xcy
 * @Description Spring利用依赖注入（DI）,完成对IOC容器中各个组件的依赖关系赋值
 *
 * 1）、@Autowired:自动注入：
 *      1) 、默认优先按照类型去容器中对应的组件：applicationContext.getBean(UserDao.class),找到就赋值。
 *      2) 、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找: applicationContext.getBean("userDao")
 *      3) 、@Qualifier("userDao2"):使用@Qualifier指定需要装配的组件id，而不是使用属性名
 *      4）、自动装配默认一定要将属性赋值好，没有就会报错：
 *              可以使用@Autowired(required=false);来进行配置不一定必需要将属性赋值，有则赋值，没有就没有。
 *      5）、@Primary:让spring自动装配的时候，默认使用首选的bean
 *      UserService{
 *          @Autowired
 *          UserDao userDao;
 *      }
 * 2）、Spring还支持使用@Resource(JSR250规范)和@Inject(JSR330)[JAVA规范的注解]
 *      @Resource 可以和@Autowired一样实现自动装配的功能；默认是按照组件名称进行装配，但是没有支持@Primary和@Autowired(required=false)的功能。
 *      @Inject 需要额外导入javax.inject的包，和Autowired的功能一样
 *
 * @Autowired 是Spring定义的，@Resource 是java规范定义的。
 *
 * @date 2021/10/18 23:39
 */
@Configuration
@ComponentScan({"com.xcy.service", "com.xcy.controller", "com.xcy.dao"})
public class MainConfigOfAutowired {

    @Bean("userDao2")
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setLabel("通过@Bean注解注入的userDao bean, id = userDao2");
        return userDao;
    }

}
