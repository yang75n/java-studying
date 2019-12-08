package com.yqw.java.reflect.classLoader;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println(new ClassLoaderDemo().getClass().getClassLoader());
    }
}
