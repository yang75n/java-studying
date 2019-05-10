package com.test.java8.defaultMethod;

/**
 * Created by iQiwen on 2019/5/8.
 */
@FunctionalInterface
public interface Service {

    void show1();

    default void show() {
        System.out.println("接口中默认方法 show");
    }

    default void show2() {
        System.out.println("接口中默认方法show2");
    }

    static void show3() {
        System.out.println("接口静态函数");
    }
}
