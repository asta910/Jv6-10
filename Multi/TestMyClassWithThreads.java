package com.demo.test;

import com.demo.beans.MyClass;
import com.demo.threads.FactorialThread;
import com.demo.threads.PrintTableThread;
import com.demo.threads.SumDigitsThread;

public class TestMyClassWithThreads {

	public static void main(String[] args) {
		MyClass ob=new MyClass();
		MyClass ob1=new MyClass();
		PrintTableThread th1=new PrintTableThread(ob,3);
		FactorialThread ft=new FactorialThread(ob,5);
		PrintTableThread th2=new PrintTableThread(ob1,7);
		//to start Runnable object we need to attach a Thread class object to it
		SumDigitsThread sm=new SumDigitsThread(ob, 4567);
		Thread th3=new Thread(sm);
		//changing the priority of the thread
		//for setting priority never use numbers , always use enum
		th1.setPriority(Thread.MAX_PRIORITY);
		//to set the thread as deamon thread
		//th1.setDaemon(true);
		th3.start();
		th1.start();
		ft.start();
		th2.start();
		
		try {
			th1.join();
			ft.join(300);
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//th3.start(); //runtime exception
		System.out.println("remaining part of main method");
		
	}

}
