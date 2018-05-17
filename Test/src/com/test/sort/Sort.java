package com.test.sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {

	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100);
		}
		System.out.println(Arrays.toString(arr));
		long starttime = System.currentTimeMillis();
		// System.out.println(Arrays.toString(bubbleSort(arr)));
		// System.out.println(Arrays.toString(selectionSort(arr)));
		System.out.println(Arrays.toString(insertionSort(arr)));
		System.out.println("use time=" + (System.currentTimeMillis() - starttime));

	}

	public static int[] bubbleSort(int arr[]) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) { // 相邻元素两两对比
					int temp = arr[j + 1]; // 元素交换
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static int[] selectionSort(int arr[]) {
		int len = arr.length;
		int minIndex, temp;
		for (int i = 0; i < len - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[minIndex]) { // 寻找最小的数
					minIndex = j; // 将最小数的索引保存
				}
			}
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}

	public static int[] insertionSort(int[] arr) {
		int len = arr.length;
		int preIndex, current;
		for (int i = 1; i < len; i++) {
			preIndex = i - 1;
			current = arr[i];
			while (preIndex >= 0 && arr[preIndex] > current) {
				arr[preIndex + 1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex + 1] = current;
		}
		return arr;
	}

}