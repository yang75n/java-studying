package com.test;

import java.io.IOException;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		try {
			// int i = System.in.read();
			byte[] b = new byte[20];
			// System.out.println("i=" + i);
			System.out.println(new String(b));
			int j = System.in.read(b);
			System.out.println("j=" + j);
			System.out.println("b=" + Arrays.toString(b));

			b[0]= 97;
			b[1]=113;
			System.out.println("b=" + Arrays.toString(b));

			System.out.println(new String(b));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@org.junit.Test
	public void t1() {
		while (true) {
			try {
				System.out.println("Please input:");
				int i = System.in.read();
				System.out.println("i=" + i);
				// System.out.println("(char) i=" + (char) i);
				if (i == 113) {
					System.out.println("q 退出");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
