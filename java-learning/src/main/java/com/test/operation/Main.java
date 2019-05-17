package com.test.operation;

public class Main {
    public static void main(String[] args) {
        final int i = 9;
        System.out.println(i & 9);// 按位取与
        System.out.println(2 | 1 | 4 | 8);// 按位取或
        System.out.println(9 ^ 0);// 按位异或运行
        System.out.println(9 ^ 9);
        System.out.println(i);

        //交换两个整数的值时可以不用第三个参数
        int a = 11, b = 9;
        a = a ^ b;
        System.out.printf("a=%d,b=%d\n", a, b);
        b = b ^ a;//此时b=a
        System.out.printf("a=%d,b=%d\n", a, b);
        a = a ^ b;//此时a=b
        System.out.printf("a=%d,b=%d\n", a, b);//成交交换

    }
}
