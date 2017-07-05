package com.kvs.algorithm.sample;

public class AbsoluteMax {

	public int solution(int[] A) {

		int start = 0;
		int p = 1;
		int n = A.length;

		int absMax = 0;
		int diff=0;

		while (p < n) {
			
			for (int i = start; i < p; i++) {
				diff = A[i]-A[p];
			}			
			if (diff>absMax) {
				absMax=diff;
			}else{
				start++;
				p++;
				diff=0;
			}
		}

		return absMax;
	}

	public static void main(String[] args) {
		AbsoluteMax solution = new AbsoluteMax();

		int[] A = { 1,3,-3 };
		//int[] A = { 4,3,2,5,1,1 };
		
		 
		System.out.println(solution.solution(A));

	}
}
