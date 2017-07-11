package com.kvs.sample.ds.sorting;

import java.util.Arrays;

/**
 * Reference
 * http://www.java2novice.com/images/selectionsort.jpg
 * @author kvs
 *
 */
public class SelectionSort {

	public static void main(String args[]) {
		int[] input = { 23, 12, 34, 0, 1 };
		selectionSort(input);
	}

	private static void selectionSort(int[] input) {

		int size = input.length;
		for (int i = 0; i < size; i++) {
			int index = i;
			for (int j = i + 1; j < size; j++) {
				if (input[j] < input[i] && input[j] < input[index]) {
					index = j;
				}
			}
			int smallNumber = input[index];
			input[index] = input[i];
			input[i] = smallNumber;

			System.out.println("Inner iteration" + Arrays.toString(input));

			System.out.println("Main iteration" + Arrays.toString(input));
			System.out.println("************************************");
		}

	}
}
