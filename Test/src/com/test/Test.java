package com.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	public static void main(String[] args) {
		System.out.println(Float.MAX_VALUE);
		Lock lock = new ReentrantLock();
		System.out.println(lock.hashCode());
		lock.equals("");
		

	}
}
