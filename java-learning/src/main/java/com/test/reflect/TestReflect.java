package com.test.reflect;

public class TestReflect {
    public static void main(String[] args) {
        String str = "abc";
        Class cls1 = str.getClass();
        Class cls2 = String.class;
        Class cls3 = null;//必须要加上null
        try {
            cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);


        System.out.println(cls1.isPrimitive());
        System.out.println(int.class.isPrimitive());//判定指定的 Class 对象是否表示一个基本类型。
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);
        System.out.println(int[].class.isPrimitive());
        System.out.println(int[].class.isArray());
    }

}
/** true
 true
 false
 true
 false
 true
 false
 true
 */