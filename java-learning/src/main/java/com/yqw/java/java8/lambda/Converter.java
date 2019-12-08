package com.yqw.java.java8.lambda;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}