package com.kvs.hacker.sample;

public class Test1 {
	
	String temp[]={"a","b","c"};

	public int divide(int a , int b){
		
		int c=-1;
		
		try{
			c=a/b;
		}catch (Exception e){
			System.err.print("Exception");
		}finally {
			System.err.print("Finally");
		}
		
		return c;
	}
	
	public static void main(String args[]){
		new Test1().divide(5,2);
	}
}
