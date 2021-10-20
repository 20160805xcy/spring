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
 * 3）、@Autowired可以使用在构造方法上，字段属性，参数，方法，注解类型上
 *       标注在方法上：Spring容器创建当前对象，就会调用方法，完成赋值，方法 使用的参数，自定义类型的值从ioc容器中获取。@Bean标注的方法创建对象的时候，方法参数的值从容器中获取。默认不写@Autowired,效果是一样的，可以省略，都能自动装配。
 *       标注在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取。
 * 4）、自定义组件想要使用Spring容器底层的一些组件（ApplicationContext,BeanFactory,xxx）;自定义组件实现xxxAware.在创建对象的时候，会调用接口规定的方法注入相关组件。
 *          通过看Aware接口的设计来进行参考，
 *          把Spring底层的一些组件注入到自定义的Bean中。
 *          xxxAware：功能使用xxxProcessor后置处理器来进行处理的-->如ApplicationContextAware==>ApplicationContextAwareProcessor
 *
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
