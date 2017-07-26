package com.kvc.hacker.np;
public class Solution {

	
	/**
	 * Returns n to the power of p.
	 * @param n
	 * @param p
	 * @return n to the power of p
	 * @throws Exception
	 */

	static int power(int n , int p) throws Exception{

		if(n<0||p<0){
			throw new Exception("n and p should be non-negative");
		}
		
		return (int)Math.pow(n,p);
	}

	public static void main(String args[]){
		try {
			System.out.println(Solution.power(5, 6));
			System.out.println(Solution.power(5, -6));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
