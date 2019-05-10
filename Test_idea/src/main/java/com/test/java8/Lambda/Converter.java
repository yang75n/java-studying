package com.test.java8.Lambda;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}