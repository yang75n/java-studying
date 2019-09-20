package com.yqw.java.concurrent.thread;

public class TestThread3 {
    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "=" + i);
                    }
                }
            }
        }, "线程1");
        t1.start();
        t1.sleep(10000);
        //join方法使得当前线程在t1执行完成之后才能继续执行
        //join方法 迫使t2 必须等线程1 执行完 才能执行 然而 t1输出完自己的 睡着了 t2被迫等了10秒
        t1.join();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "=" + i);
                    }
                }
            }
        }, "线程2");
        t2.start();

    }
}