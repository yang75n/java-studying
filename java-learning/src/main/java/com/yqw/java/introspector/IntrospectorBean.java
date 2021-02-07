package com.yqw.java.introspector;

//内省demo javaBean
public class IntrospectorBean {
    private String name;
    private Integer age;

    public int getAb() {
        System.out.println("IntrospectorDemo getAb");
        return 0;
    }

    public void setAbcd() {
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
}