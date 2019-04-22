package com.test.j_u_concurrent;

import java.util.concurrent.Exchanger;

/**
 * Exchanger 用于两个线程之间交互信息.可简单地将Exchanger对象理解为一个包含两个格子的容器，通过exchanger方法可以向两个格子中填充信息。当两个格子中的均被填充时，该对象会自动将两个格子的信息交换，然后返回给线程，从而实现两个线程的信息交换。
 * Created by iQiwen on 2019/4/22.
 */
public class TestExchanger extends Thread {
    private Exchanger<String> exchanger;
    private String string;
    private String threadName;

    public TestExchanger(Exchanger<String> exchanger, String string,
                         String threadName) {
        this.exchanger = exchanger;
        this.string = string;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " start run...");
        try {
            System.out.println(threadName + ": " + exchanger.exchange(string));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        TestExchanger test1 = new TestExchanger(exchanger, "string1",
                "thread-1");
        TestExchanger test2 = new TestExchanger(exchanger, "string2",
                "thread-2");

        System.out.println(Thread.currentThread().getName());

        test1.start();
        test2.start();
    }

}
