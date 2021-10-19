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
 *      1）、默认优先按照类型去容器中对应的组件：applicationContext.getBean(UserDao.class),找到就赋值。
 *      2)、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找: applicationContext.getBean("userDao")
 *
 *      UserService{
 *          @Autowired
 *          UserDao userDao;
 *      }
 *
 *
 * @date 2021/10/18 23:39
 */
@Configuration
@ComponentScan({"com.xcy.service", "com.xcy.controller", "com.xcy.dao"})
public class MainConfigOfAutowired {

    //@Bean("userDao2")
    //public UserDao userDao() {
    //    UserDao userDao = new UserDao();
    //    userDao.setLabel("通过@Bean注解注入的userDao bean, id = userDao2");
    //    return userDao;
    //}

}
