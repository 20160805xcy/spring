package com.xcy;

/**
 * @author xcy
 * @Description
 * @date 2021/10/16 19:57
 */
public class Person {
    private String name;
    private Integer age;

    public Person() {
        System.out.println("person bean 无参方法 初始化");
    }

    public Person(String name, Integer age) {
        System.out.println("person bean 有参方法 初始化");
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
