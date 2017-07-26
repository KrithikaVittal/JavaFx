package com.kvc.hacker.anagram;

import java.util.*;

public class Solution {
	public static int numberNeeded(String first, String second) {

		if (first.equals(second)) {
			return 0;
		}
		
		char[] firstChars = first.toCharArray();
		char[] secondChars = second.toCharArray();
		
		Arrays.sort(firstChars);
		Arrays.sort(secondChars);
		System.out.println("firstChars"+firstChars.length);
		
		if (Arrays.equals(firstChars, secondChars)) {
			return 0;
		}

		int count=0;
		
		for (int i = 0; i < firstChars.length; i++) {
			for (int j = 0 ; j < secondChars.length; j++) {

				System.out.println("firstChars[i] - i --->"+i +"--->"+firstChars[i]);
				System.out.println("secondChars[j] - j --->"+j +"--->"+secondChars[j]);
				
				if(secondChars[j]<firstChars[i]){
					count++;
					System.out.println("count - "+count);
					break;
				}
			}
		}

		return count;

	}

	public static void main(String[] args) {

		System.out.println(numberNeeded("cabf", "abc"));
	}
}