package com.techleads.app.namingthreads2;

import java.util.concurrent.TimeUnit;

public class NamingThreadsSecond {
	
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main thread starts here...");

		new Thread(new LoopTaskC(),"Worker-1").start();
		
		
		Thread t2 = new Thread(new LoopTaskC());
//		t2.setName("Worker-2");
		t2.start();
		
		try {
			TimeUnit.MILLISECONDS.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[ " + currentThreadName + " ] Renaming Second thread now...");
		//We can rename the thread name even if it is already started
		t2.setName("Worker-2");
		System.out.println("[ " + currentThreadName + " ] Main thread ends here...");
	}

}
