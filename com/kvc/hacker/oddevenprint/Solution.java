package com.kvc.hacker.oddevenprint;
public class Solution {

	/*
	 * Complete the function below.
	 */

	static String findNumber(int[] arr, int k) {

		for (int i = 0; i < arr.length; i++) {
			if (k == arr[i]) {
				return "YES";
			}
		}

		return "NO";
	}

	static int[] oddNumbers(int l, int r) {

		int[] oddNumbers = new int[r - l];
		int index = 0;
		for (int i = l; i <= r; i++) {
			if (i % 2 != 0) {
				oddNumbers[index] = i;
				index++;
			}
		}
		int[] result=new int[index];
		result=oddNumbers;
		 System.arraycopy( oddNumbers, 0, result, 0, index );
		return result;
	}

	public static void main(String args[]) {
		System.out.println(oddNumbers(1,9));
	}

}
