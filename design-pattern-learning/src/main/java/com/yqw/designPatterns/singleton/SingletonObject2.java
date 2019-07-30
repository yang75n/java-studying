package com.yqw.designPatterns.singleton;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * <p>
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：较复杂
 * <p>
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class SingletonObject2 {

    private volatile static SingletonObject2 singleton;

    private SingletonObject2() {
    }

    public static SingletonObject2 getSingleton() {
        if (singleton == null) {
            synchronized (SingletonObject2.class) {
                if (singleton == null) {
                    singleton = new SingletonObject2();
                }
            }
        }
        return singleton;
    }
}