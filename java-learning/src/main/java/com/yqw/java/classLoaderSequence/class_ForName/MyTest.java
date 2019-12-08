package com.yqw.java.classLoaderSequence.class_ForName;


import org.junit.Test;

public class MyTest {
    @Test
    public void test1() {
        try {
            Class.forName("com.yqw.java.classLoaderSequence.class_ForName.ClassForName");
            System.out.println("#########分割符(上面是Class.forName的加载过程，下面是ClassLoader的加载过程)##########");
            ClassLoader.getSystemClassLoader().loadClass("com.yqw.java.classLoaderSequence.class_ForName.ClassForName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}