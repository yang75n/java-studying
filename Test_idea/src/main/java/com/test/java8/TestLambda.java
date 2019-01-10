package com.test.java8;

public class TestLambda {

	public static void main(String[] args) {
		MyIntegerCalculator myIntegerCalculator = (Integer s1) -> s1 * 2;

		System.out.println("1- Result x2 : " + myIntegerCalculator.calcIt(5));

	}
}

@FunctionalInterface
interface MyIntegerCalculator {

	public Integer calcIt(Integer s1);

}