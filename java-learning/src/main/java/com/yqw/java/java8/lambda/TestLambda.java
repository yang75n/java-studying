package com.yqw.java.java8.lambda;

public class TestLambda {


    public static void main(String[] args) {
        //会自动推断s1的类型,也可以写成（Integer s1）
        MyIntegerCalculator myIntegerCalculator = (s1) -> s1 * 2;

        System.out.println("1- Result x2 : " + myIntegerCalculator.calcIt(5));

    }
}

@FunctionalInterface
interface MyIntegerCalculator {

    public Integer calcIt(Integer s1);

}