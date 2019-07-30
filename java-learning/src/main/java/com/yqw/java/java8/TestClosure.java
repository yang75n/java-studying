package com.yqw.java.java8;

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

    public static Supplier<Integer> testClosure3() {
        int i = 1;
        return () -> i;
    }

    @FunctionalInterface
    public interface Supplier<T> {
        T get();

        default T set() {
            return null;
        }

    }

    @Test
    public void t() {
        System.out.println("start");
        System.out.println(testClosure().get());
        System.out.println(testClosure2().get());
        System.out.println(testClosure3().get());


    }
}
