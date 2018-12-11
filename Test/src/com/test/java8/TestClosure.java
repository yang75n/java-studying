package com.test.java8;

import org.junit.Test;

public class TestClosure {

	public static Supplier<Integer> testClosure() {
		final int i = 1;
		return new Supplier<Integer>() {
			@Override
			public Integer get() {
				return i;
			}
		};
	}

	public static Supplier<Integer> testClosure2() {
		int i = 1;
		return () -> {
			return i;
		};
	}

	public interface Supplier<T> {
		T get();
	}

	@Test
	public void t() {
		System.out.println("start");
		System.out.println(testClosure().get());
		System.out.println(testClosure2().get());
	}
}