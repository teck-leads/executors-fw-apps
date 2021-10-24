package com.techleads.app.namingthreads;

public class NamingThreadsFirst {
	
	public static void main(String[] args) {
		Thread.currentThread().setName("MainThread ");
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main thread starts here...");

		new Thread(new LoopTaskB()).start();
		
		
		Thread t2 = new Thread(new LoopTaskB());
		
		t2.start();
		System.out.println("[ " + currentThreadName + " ] Main thread ends here...");
	}

}
