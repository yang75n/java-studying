package com.yqw.java.concurrent.j_u_concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CountDownLatch是计数器，只能使用一次，而CyclicBarrier的计数器提供reset功能，可以多次使用。
 * 但是我不那么认为它们之间的区别仅仅就是这么简单的一点。
 * 我们来从jdk作者设计的目的来看，javadoc是这么描述它们的：
 * <p>
 * 对于CountDownLatch来说，重点是“一个线程（多个线程）等待”，而其他的N个线程在完成“某件事情”之后，可以终止，也可以等待。而对于CyclicBarrier，重点是多个线程，在任意一个线程没有完成，所有的线程都必须等待。
 * <p>
 * CountDownLatch是计数器，线程完成一个记录一个，只不过计数不是递增而是递减，而CyclicBarrier更像是一个阀门，需要所有线程都到达，阀门才能打开，然后继续执行。
 */
public class TestCyclicBarrier {


    public static void main(String[] args) {
        int n = 4;
        CyclicBarrier barrier = new CyclicBarrier(n, () ->
                System.out.println("await结束，当前线程" + Thread.currentThread().getName())
        );
        for (int i = 0; i < n; i++) {
            new Writer(barrier).start();
        }
    }


    static class Writer extends Thread {

        private CyclicBarrier cyclicBarrier;


        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }


        @Override


        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000); //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                //调用await state+1；当等于指定值时候释放所有线程.
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，线程" + Thread.currentThread().getName() + "继续处理其他任务...");
        }

    }
}