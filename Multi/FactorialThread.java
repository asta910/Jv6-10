package com.demo.threads;

import com.demo.beans.MyClass;

public class FactorialThread extends Thread{
	private MyClass ob;
	private int n;
	
	public FactorialThread(MyClass ob, int n) {
		super();
		this.ob = ob;
		this.n = n;
	}

	public void run() {
		int ans=ob.factorial(n);
		System.out.println("Factorial : "+ans);
	}

}
