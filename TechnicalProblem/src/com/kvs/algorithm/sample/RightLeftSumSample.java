package com.kvs.algorithm.sample;

public class RightLeftSumSample {

	public int solution(int[] A) {

		int start = 0;
		int p = 1;
		int n = A.length;

		int rightSum = 0;
		int leftSum = 0;

		while (p < n) {
			
			for (int i = start; i < p; i++) {
				leftSum += A[i];
			}
			
			for (int i = p+1; i < n; i++) {
				rightSum += A[i];
			}
			if (leftSum == rightSum) {
				return p;
			}else{
				p++;
				leftSum=0;
				rightSum=0;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		RightLeftSumSample solution = new RightLeftSumSample();

		int[] A = { 8, 2,1, 3,4 };

		System.out.println(solution.solution(A));

	}
}
