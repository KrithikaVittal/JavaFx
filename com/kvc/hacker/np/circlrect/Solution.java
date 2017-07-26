package com.kvc.hacker.np.circlrect;
public class Solution {
	
	public static void main(String args[]){
	

	}
}


class Circle{
	
	float radius;
	
	public Circle(float radius) {
		this.radius = radius;
	}

	public int getArea(){
		
		return (int) Math.round( (3.14*radius*radius));
	}

}

class Rectangle{
	
	float width;
	
	float length;
	
	public Rectangle(float width, float length) {
		this.width = width;
		this.length = length;
	}

	public int getArea(){
		
		return  (int) (width*length);
	}

}

class Square{
	
	float width;
	
	public Square(float width) {
		this.width = width;
	}

	public int getArea(){
		
		return (int) (width*width);
	}

}