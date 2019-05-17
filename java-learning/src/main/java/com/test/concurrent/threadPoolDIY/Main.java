package com.test.concurrent.threadPoolDIY;

/**
 * Created by iQiwen on 2018/12/12.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            ThreadPool.getInstance().start(() -> {
                try {
                    //休眠100ms
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    //System.out.println("你好");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
