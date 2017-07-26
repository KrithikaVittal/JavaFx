package com.kvc.hacker.np.openclosebraces;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

	static String findMatch(String value) {

		Stack<Character> stack = new Stack<>();

		char[] values = value.toCharArray();

		for (int i = 0; i < values.length; i++) {
			if (values[i] == '{' || values[i] == '(' || values[i] == '[') {
				stack.push(values[i]);
			} else {
				if (values[i] == '}') {
					if (stack.isEmpty()||stack.pop() != '{') {
						return "NO";
					}
				}
				if (values[i] == ')') {
					if (stack.isEmpty()||stack.pop() != '(') {
						return "NO";
					}
				}
				if (values[i] == ']') {
					if (stack.isEmpty()||stack.pop() != '[') {
						return "NO";
					}
				}
			}
		}
		
		if (stack.isEmpty()) {
			return "YES";
		}
		
		return "YES";
	}

	static String[] braces(String[] values) {
		
		String[] result=new String[values.length];

		for (int i = 0; i < values.length; i++) {

			result[i]=findMatch(values[i]);

		}

		return result;
	}

	public static void main(String args[]) {

		System.out.println(Arrays.toString(braces(new String[] { "{}[]()" ,"{[}]"})));
		System.out.println(Arrays.toString(braces(new String[] { "{()}" ,"{[}]"})));

	}
}
