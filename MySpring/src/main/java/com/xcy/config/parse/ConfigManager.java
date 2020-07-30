package com.xcy.config.parse;

import com.xcy.config.Bean;
import com.xcy.config.Property;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author xcy
 * @Desc 读取解析配置文件获取初始化bean的信息
 * @date 2020/7/30 22:44
 * @Version v1.0
 */
public class ConfigManager {
    // 读取配置文件 =>并返回读取结果
    public static Map<String, Bean> getConfig(String path) {
        // 创建一个用于返回的map对象
        Map<String, Bean> map = new HashMap<String, Bean>();

        // dom4j实现
        // 1.创建解析器
        SAXReader reader = new SAXReader();
        // 2.加载配置文件=>document对象
        InputStream is = ConfigManager.class.getResourceAsStream(path);
        Document doc;
        try {
            doc = reader.read(is);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException("请检查xml文件是否配置正确");
        }
        // 3.定义xpath表达式，取出Bean元素
        String xpath = "//bean"; // "//"表示从整个配置文件中找bean的元素
        // 4.对Bean元素进行遍历
        List<Element> list = doc.selectNodes(xpath);
        if (null != list) {
            for (Element beanEle : list) {
                // 将bean元素的name、class属性封装到Bean对象中
                Bean bean = new Bean();
                String name = beanEle.attributeValue("name");
                String clazz = beanEle.attributeValue("class");
                bean.setName(name);
                bean.setClassName(clazz);
                // 获得Bean元素下的所有Property子元素，将name,value,ref属性封装到Property对象
                List<Element> childrenEle = beanEle.elements("property");
                if (null != childrenEle) {
                    for (Element children : childrenEle) {
                        Property property = new Property();
                        String pName = children.attributeValue("name");
                        String pValue = children.attributeValue("value");
                        String pRef = children.attributeValue("ref");
                        property.setName(pName);
                        property.setValue(pValue);
                        property.setRef(pRef);
                        // 将Property对象封装到Bean对象
                        bean.getProperties().add(property);
                    }
                }
                // 将Bean对象封装到Map中
                map.put(name, bean);
            }
        }
        // 5.返回Map结果
        return map;
    }
}
