package com.xcy.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author xcy
 * @Desc
 * @date 2020/7/30 22:32
 * @Version v1.0
 */
public class Dom4jTest {
    /**
     * 利用xpath表达式遍历document文档,获取bean节点下的所有属性为name,class的值.
     * @param args
     */
    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();

        InputStream stream = Dom4jTest.class.getResourceAsStream("/myApplicationContext.xml");

        Document document;

        try {
            document = saxReader.read(stream);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException("xml格式错误");
        }

        String xpath = "//bean";

        List<Element> nodes = document.selectNodes(xpath);

        if (null != nodes) {
            for (Element element : nodes) {
                System.out.println(element.attributeValue("name"));
                System.out.println(element.attributeValue("class"));
            }
        }

    }
}
