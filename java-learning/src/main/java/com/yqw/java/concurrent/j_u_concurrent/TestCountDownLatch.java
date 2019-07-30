package com.yqw.java.concurrent.j_u_concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 的三种典型用法
 * ①某一线程在开始运行前等待n个线程执行完毕。将 CountDownLatch 的计数器初始化为n ：new CountDownLatch(n)，
 * 每当一个任务线程执行完毕，就将计数器减1 countdownlatch.countDown()，当计数器的值变为0时，
 * 在CountDownLatch上 await() 的线程就会被唤醒。一个典型应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行。
 * <p>
 * ②实现多个线程开始执行任务的最大并行性。注意是并行性，不是并发，
 * 强调的是多个线程在某一时刻同时开始执行。类似于赛跑，将多个线程放到起点，等待发令枪响，
 * 然后同时开跑。做法是初始化一个共享的 CountDownLatch 对象，将其计数器初始化为 1 ：new CountDownLatch(1)，
 * 多个线程在开始执行任务前首先 coundownlatch.await()，当主线程调用 countDown() 时，计数器变为0，多个线程同时被唤醒。
 * <p>
 * ③死锁检测：一个非常方便的使用场景是，你可以使用n个线程访问共享资源，在每次测试阶段的线程数目是不同的，并尝试产生死锁。
 */
public class TestCountDownLatch {


    /**
     * 某一线程在开始运行前等待n个线程执行完毕
     */
    @Test
    public void test1() {

        final CountDownLatch latch = new CountDownLatch(2);

        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    //调用countDown时，state-1
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }.start();

        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    //调用countDown时，state-1
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            //调用await时候阻塞，state=0的时候释放所有线程
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 实现多个线程开始执行任务并发
     */
    @Test
    public void test2() {
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    try {
                        System.out.println("子线程" + Thread.currentThread().getName() + "正在等待");
                        //调用await时候阻塞，state=0的时候释放所有线程
                        latch.await();
                        System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                        Thread.sleep(2000);
                        System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }.start();
        }
        //等待一会儿，让上面的线程创建完成。
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //单曲有多少线程
        Thread.currentThread().getThreadGroup().list();
        //调用countDown时，state-1
        latch.countDown();
        while (Thread.activeCount() > 2) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread.yield();
        }
        //单曲有多少线程
        Thread.currentThread()
                .getThreadGroup().list();
    }
}