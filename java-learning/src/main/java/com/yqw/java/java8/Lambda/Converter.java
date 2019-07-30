package com.yqw.java.java8.Lambda;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}