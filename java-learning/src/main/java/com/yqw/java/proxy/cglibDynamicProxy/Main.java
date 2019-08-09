package com.yqw.java.proxy.cglibDynamicProxy;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    /**
     * 和jdk动态代理不一样的是，
     * cglib生成的方法会继承被代理类（jdk动态代理是实现同一个接口），
     * 然后生成的方法也和jdk的一样，会调用MethodInterceptor也就是这里的HuangNiu的intercept方法。
     *
     * @param args
     */
    public static void main(String[] args) {
        HuangNiu huangNiu = new HuangNiu();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CommonPerson.class);
        enhancer.setCallback(huangNiu);

        //代理类的生成逻辑在Enhancer.create方法里。
        CommonPerson person = (CommonPerson) enhancer.create();
        person.buyTicket();
    }
}
