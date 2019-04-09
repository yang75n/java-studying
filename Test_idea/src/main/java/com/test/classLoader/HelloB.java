package com.test.classLoader;

/**
 * 这是网易2015校招Java面试题,直接上题目。
 * static A
 * static B
 * I’m A class
 * HelloA
 * I’m B class
 * HelloB
 */
public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("I’m B class");
    }

    static {

        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}

class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }

    {
        System.out.println("I’m A class");
    }

    static {
        System.out.println("static A");
    }
}