package com.yqw.java.proxy.cglibDynamicProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//代理类需要实现MethodInterceptor接口
public class HuangNiu implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("黄牛帮忙代购");
        Object res = methodProxy.invokeSuper(o, objects);
        return res;
    }
}