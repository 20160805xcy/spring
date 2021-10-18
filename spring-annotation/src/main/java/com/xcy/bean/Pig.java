package com.xcy.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author xcy
 * @Description
 * @date 2021/10/18 22:45
 */
public class Pig {

    // 使用@Value注解赋值：
    // 1、基本数值
    // 2、可以写SpEL: #{}
    // 3、可以写${}: 取出配置文件的值（在运行环境变量中的值）

    @Value("猪八戒")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${pig.weight}")
    private Integer weight;

    public Pig() {
    }

    public Pig(String name, Integer age, Integer weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
