package com.demo.threads;

import com.demo.beans.MyClass;

public class SumDigitsThread implements Runnable{
    private MyClass ob;
    private int num;
    
	public SumDigitsThread(MyClass ob, int num) {
		super();
		this.ob = ob;
		this.num = num;
	}

	@Override
	public void run() {
		int ans=ob.sumdigits(num);
		System.out.println("Sumdigits : "+ans);
		
	}

}
