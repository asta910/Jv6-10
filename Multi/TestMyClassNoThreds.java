package com.demo.test;

import com.demo.beans.MyClass;

public class TestMyClassNoThreds {

	public static void main(String[] args) {
		MyClass ob=new MyClass();
		ob.printTable(3);
		int ans=ob.factorial(5);
		System.out.println("Factorial : "+ans);
		ob.printTable(7);
		System.out.println("remaining part of main method");
	}

}
