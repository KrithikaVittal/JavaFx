package com.kvs.algorithm.sample;

public class StringManipulator {

	public int solution(String S) {
				
        String[] sentenceArr=S.split("\\?|\\.|\\\"|\\!");
                
        int maxWords=0;
        for(String sentence:sentenceArr){
        	System.out.println(sentence);
        	sentence=sentence.trim();
        	String[] words=sentence.split("\\s+");
        	if(maxWords<words.length){
        		maxWords=words.length;
        	}
        }
        
        return maxWords;
    }

	public static void main(String[] args) {
		StringManipulator solution = new StringManipulator();

		//System.out.println("Output\n"+solution.solution("We test coders why. Give us a try?"));
		System.out.println("Output\n"+solution.solution("Forget  CVs..Save time . x x"));
		

	}
}
