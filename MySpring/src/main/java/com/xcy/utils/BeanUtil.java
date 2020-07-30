package com.xcy.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author xcy
 * @Desc
 * @date 2020/7/30 23:06
 * @Version v1.0
 */
public class BeanUtil {
    /**
     * 根据bean对象和属性名称获取其对应的属性的set方法.
     * @param beanObj bean对象
     * @param name 要获得的Bean对象对应的属性名称
     * @return
     */
    public static Method getWriteMethod(Object beanObj, String name) {
        // 使用内省技术来实现该方法
        Method writeMethod = null;
        // 1.分析Bean对象=> BeanInfo
        try {
            BeanInfo info = Introspector.getBeanInfo(beanObj.getClass());
            // 2.根据BeanInfo获得所有属性的描述器
            PropertyDescriptor[] pds = info.getPropertyDescriptors();
            // 3.遍历这些属性描述器
            if (null != pds) {
                for (PropertyDescriptor pd : pds) {
                    // 判断当前遍历的描述器描述的属性是否是我们要找的属性
                    // 获得当前描述器描述的属性名称
                    String pName = pd.getName();
                    // 使用我们要找的属性与当前描述器的属性名称对比
                    if (pName.endsWith(name)) {
                        // 比对一致=>找到了，获得写入属性的set方法
                        writeMethod = pd.getWriteMethod();
                    }
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        // 如果没有找到=>抛出异常提示用户检查是否创建属性对应的set方法
        if (null == writeMethod) {
            throw new RuntimeException("请检查" + name + "属性是否提供了set方法");
        }
        // 4. 返回找到的set方法
        return writeMethod;
    }
}
