package com.yqw.java.classLoaderSequence;

/**
 * yqw static
 * myclass static
 * person static
 * person Test
 * yqw constructor
 * person MyClass
 * myclass constructor
 */
public class Test {
    Person person = new Person("Test");

    static {
        System.out.println("yqw static");
    }

    public Test() {
        System.out.println("yqw constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class Person {
    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person " + str);
    }
}


class MyClass extends Test {
    Person person = new Person("MyClass");

    static {
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}