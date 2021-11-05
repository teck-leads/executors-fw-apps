package com.techleads.app.terminatingthreads;

import java.util.concurrent.TimeUnit;

public class TerminatingThreadsFirstTech {
	
	public static void main(String[] args) {
		String currentTheadName = Thread.currentThread().getName();
		System.out.println("["+currentTheadName+"] main thread starts here...");
		
		LoopTaskE t1=new LoopTaskE();
		LoopTaskE t2=new LoopTaskE();
		LoopTaskE t3=new LoopTaskE();
//		LoopTaskE t4=new LoopTaskE();
		new Thread(t1, "MyThread-1").start();
		new Thread(t2, "MyThread-2").start();
		new Thread(t3, "MyThread-3").start();
//		new Thread(t4, "MyThread-4").start();
		
		
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		t1.cancel();
		t2.cancel();
		t3.cancel();
//		t4.cancel();
		
		
		System.out.println("["+currentTheadName+"] main thread ends here...");
		
		
	}

}
