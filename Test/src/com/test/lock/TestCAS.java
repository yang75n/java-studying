package com.test.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCAS {

	volatile static int count = 0;// 需要加同步才能保证
	static AtomicInteger atomicInteger = new AtomicInteger(0);// 底层通过CAS方式保证加了锁

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (int j = 0; j < 100; j++) {
						// synchronized (TestCAS.class) {// 一定要保证同一把锁
						// count++;
						// }
						atomicInteger.incrementAndGet();
					}
				}
			}).start();
		}
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(count);
		System.out.println(atomicInteger.get());
	}
}
