package com.yqw.java.reflect.classLoader;

public class ClassLoaderDemo {
    /**
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * sun.misc.Launcher$ExtClassLoader@12a3a380
     * null
     */
    public static void main(String[] args) {
        System.out.println(new ClassLoaderDemo().getClass().getClassLoader());
        System.out.println(new ClassLoaderDemo().getClass().getClassLoader().getParent());
        System.out.println(new ClassLoaderDemo().getClass().getClassLoader().getParent().getParent());


    }
}
