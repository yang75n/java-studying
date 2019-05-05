package com.test.concurrent.waitNotify;

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
                System.out.println("start wait1...");

                try {
                    //wait和notiry加synchronized是为了保证wait和notify的原子性
                    synchronized (lock2) {
                        System.out.println("start wait2...");
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
