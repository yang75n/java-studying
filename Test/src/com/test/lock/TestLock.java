package com.test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class TestLock {

	private int count = 200;// AtomicInteger
	Lock Lock = new ReentrantLock();

	@Test
	public void Test() throws InterruptedException {
		Thread t1 = new Thread(new TicketRunnable());
		Thread t2 = new Thread(new TicketRunnable());
		Thread t3 = new Thread(new TicketRunnable());
		Thread t4 = new Thread(new TicketRunnable());
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		Thread.currentThread().join();

	}

	public class TicketRunnable implements Runnable {

		public void run() {
			while (count > 0) {
				if (count > 0) {
					System.out.println("卖出了第" + count-- + "张票");
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
