package com.test;

import java.io.IOException;
import java.util.Arrays;

public class Test {

	@org.junit.Test
	public void t6() {
		float f = 9;
		int i = 1;
		System.out.println(i>>3);
		System.out.println(Float.floatToIntBits(f));
	}

	@org.junit.Test
	public void t5() {
		int a = 9;
		int b = 8;
		used4t5(a, b);
		System.out.println(a);
		System.out.println(b);
	}

	public void used4t5(int a, int b) {
		a = b;
		b = a;
	}

	@org.junit.Test
	public void t4() {
		System.out.println(233 % 8);
		System.out.println(233 % 8 ^ 5 ^ 5);
		System.out.println(233 % 8 | 5 | 5);
	}

	public void t3() {
		try {
			System.out.println(System.getProperties());
			// int i = System.in.read();
			byte[] b = new byte[20];
			// System.out.println("i=" + i);
			System.out.println(new String(b));
			int j = System.in.read(b);
			System.out.println("j=" + j);
			System.out.println("b=" + Arrays.toString(b));

			b[0] = 97;
			b[1] = 113;
			System.out.println("b=" + Arrays.toString(b));
			System.out.println(new String(b));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@org.junit.Test
	public void t2() {
		while (true) {
			try {
				System.out.println("Please input:");
				int i = System.in.read();
				System.out.println("i=" + i);
				// System.out.println("(char) i=" + (char) i);
				if (i == 113) {
					System.out.println("q 閫�鍑�");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@org.junit.Test
	public void t1() {
		String string[] = {};
		int i = 6;
		String string2[] = new String[i];
		System.out.println(string.length);
		System.out.println(string2.length);
		System.out.println(Arrays.toString(string2));
		String NULL = "";
		int[] arr = new int[3];
		System.out.println(NULL);
	}

	@org.junit.Test
	public void t() {
		// 瀹氫箟鏁扮粍
		char[] char_arr = { 'a', 'b', 'c', 'd', 'e' };
		for (int i = 0; i < char_arr.length; i++) {
			for (int j = 0; j < char_arr.length; j++) {
				if (j == i) {
					continue;
				}
				for (int k = 0; k < char_arr.length; k++) {
					if (k == i || k == j) {
						continue;
					}
					for (int l = 0; l < char_arr.length; l++) {
						if (l == i || l == j || l == k) {
							continue;
						}
						for (int m = 0; m < char_arr.length; m++) {
							if (m == i || m == j || m == k || m == l) {
								continue;
							}
							// out.print(String.valueOf(char_arr[i]) +
							// String.valueOf(char_arr[j]) +
							// String.valueOf(char_arr[k]) +
							// String.valueOf(char_arr[l]) +
							// String.valueOf(char_arr[m]) + "<br>");
							System.out.println(String.valueOf(char_arr[i]) + String.valueOf(char_arr[j])
									+ String.valueOf(char_arr[k]) + String.valueOf(char_arr[l])
									+ String.valueOf(char_arr[m]));
						}
					}
				}
			}
		}

	}

}
