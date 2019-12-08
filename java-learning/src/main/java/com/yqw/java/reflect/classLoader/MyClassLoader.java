package com.yqw.java.reflect.classLoader;

public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}


class Test {
    public static void main(String[] args) throws Exception {
        MyClassLoader mcl = new MyClassLoader();
        System.out.println(mcl);
        System.out.println(mcl.getParent());
        Class<?> cls = mcl.loadClass("java.util.Date");
        System.out.println(cls.getClassLoader());
        Object obj = cls.newInstance();
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj);
    }
}
