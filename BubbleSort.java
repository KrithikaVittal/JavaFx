package com.kvs.sample.ds.sorting;

import java.util.Arrays;

/**
 * Reference
 * http://www.java2novice.com/images/bubblesort.jpeg
 * @author kvs
 *
 */
public class BubbleSort {

	public static void main(String args[]) {
		int[] input = { 23, 12, 34, 0, 1 };
		bubbleSort(input);
	}

	private static void bubbleSort(int[] input) {
		
		int size = input.length;
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size - 1; i++) {
				int temp = input[i];
				if (temp > input[i + 1]) {
					input[i] = input[i + 1];
					input[i + 1] = temp;
				}
				System.out.println("Inner iteration"+Arrays.toString(input));
				
			}

			System.out.println("Main iteration"+Arrays.toString(input));
			System.out.println("************************************");
		}

	}
}
