package com.test.interceptor;

/**
 * @author 维C果糖
 * @create 2017-03-30
 *
 * GitHub：github.com/guobinhit
 *
 * 业务组件接口的实现类
 */
public class BusinessClass implements BusinessFacade {
    public void doSomething() {
        System.out.println("在业务组件 BusinessClass 中调用方法: doSomething()");
    }
}
