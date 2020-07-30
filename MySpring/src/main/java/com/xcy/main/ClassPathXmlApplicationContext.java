package com.xcy.main;

import com.xcy.config.Bean;
import com.xcy.config.Property;
import com.xcy.config.parse.ConfigManager;
import com.xcy.utils.BeanUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xcy
 * @Desc 类似Context
 * @date 2020/7/30 23:01
 * @Version v1.0
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    private Map<String, Bean> config;//当成成员变量，延长生命周期
    private Map<String, Object> context = new HashMap<String, Object>();//使用map来当容器存放bean

    public ClassPathXmlApplicationContext(String path) {
        super();
        //希望在ClassPathXmlApplicationContext类一创建时便初始化Spring容器(装载bean的实例)

        // 1. 读取配置文件获取初始化bean的信息
        config = ConfigManager.getConfig(path);
        // 2. 遍历配置初始化bean
        if (null != config) {
            for (Map.Entry<String, Bean> en : config.entrySet()) {
                // 1.获取配置中的bean信息
                String beanName = en.getKey();
                Bean bean = en.getValue();

                Object existBean = context.get(beanName);
                //因为在createBean方法里面还会创建bean，所以为了让容器内符合单例，往容器里添加要判断
                //如果不存在，则进行初始化该bean
                if (null == existBean) {
                    // 2.根据bean配置信息创建bean对象
                    Object beanObj = createBean(bean);
                    // 3.将配置好的Bean放入到容器中
                    context.put(beanName, beanObj);
                }
            }
        }
    }

    /**
     * 根据bean配置创建bean实例
     * <bean name="A" class="com.xcy.bean.A">
     * <!-- 为A的属性赋值，Spring会自动将配置到值注入到A中 -->
     * <property name="name" value="xcy"></property>
     * </bean>
     */
    private Object createBean(Bean bean) {
        // 1.获得要创建的bean的class
        String className = bean.getClassName();
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("请检查xml配置文件中的完整类名是否正确");
        }
        //根据获得的Class,创建对象实例
        Object beanObj;
        try {
            beanObj = clazz.newInstance(); //调用空参构造实例
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Bean没有空参构造方法" + className);
        }

        // 2.获得bean的属性，将其注入
        if (null != bean.getProperties()) {
            for (Property prop : bean.getProperties()) {
                String name = prop.getName();
                // 根据属性名称获得注入属性对应的Set方法
                Method setMethod = BeanUtil.getWriteMethod(beanObj, name);
                // 创建一个需要注入到Bean中的属性
                Object param = null;

                // 分两种情况
                // 1.简单-->value属性注入
                if (null != prop.getValue()) {
                    String value = prop.getValue();
                    param = value;
                }

                // 2.麻烦-->其他bean的注入
                if (null != prop.getRef()) {
                    // 因为要注入其他bean到当前bean当中，要先从容器中检查是否存在该bean，如果存在则不需要再次创建，否则要重新创建
                    Object existBean = context.get(prop.getRef());

                    if (null == existBean) { //容器中不存在我们要注入的bean,则创建
                        existBean = createBean(config.get(prop.getRef()));

                        // 将创建好的bean放入到容器里
                        context.put(prop.getRef(), existBean);
                    }
                    param = existBean;
                }

                // 调用Set方法即可注入
                try {
                    setMethod.invoke(beanObj, param);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("bean的属性" + name + "没有对应的set方法，或方法参数不正确" + className);
                }
            }
        }
        return beanObj;
    }

    public Object getBean(String beanName) {
        Object bean = context.get(beanName);
        return bean;
    }
}
