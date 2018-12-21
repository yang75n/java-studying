package com.test.waitNotify;

/**
 * Created by iQiwen on 2018/12/20.
 */
public class Test {
    private static Object lock = new Object();
    private static Object lock2 = new Object();


    public static void main(String args[]) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start wait...");

                try {
                    synchronized (lock2) {
                        lock2.wait();
                        System.out.println("wait over");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        synchronized (lock2) {
            System.out.println("start notify ...");
            lock2.notify();
            System.out.println("notify over");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notify ok");

        }


    }
}
