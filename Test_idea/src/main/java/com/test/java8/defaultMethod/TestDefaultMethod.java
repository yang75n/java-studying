package com.test.java8.defaultMethod;

/**
 * Created by iQiwen on 2019/5/8.
 */
public class TestDefaultMethod implements Service {
    @Override
    public void show1() {
        System.out.println("重写接口中普通方法show1 ");
    }

    @Override
    public void show() {
        System.out.println("重写接口中默认方法 show");
    }

    public static void main(String[] args) {
        Service service = new TestDefaultMethod();
        service.show();
        service.show1();
        service.show2();
    }
}
