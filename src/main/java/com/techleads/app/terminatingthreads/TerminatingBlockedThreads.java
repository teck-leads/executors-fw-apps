package com.techleads.app.terminatingthreads;

import java.util.concurrent.TimeUnit;

public class TerminatingBlockedThreads {

	public static void main(String[] args) throws InterruptedException {
		String currentTheadName = Thread.currentThread().getName();
		System.out.println("[" + currentTheadName + "] main thread starts here...");

		LoopTaskG t1 = new LoopTaskG();
		LoopTaskG t2 = new LoopTaskG();
		LoopTaskG t3 = new LoopTaskG();
		LoopTaskG t4 = new LoopTaskG();
		Thread td1 = new Thread(t1, "MyThread-1");
		td1.start();
		Thread td2 = new Thread(t2, "MyThread-2");
		td2.start();
		Thread td3 = new Thread(t3, "MyThread-3");
		td3.start();
		
		Thread td4 = new Thread(t4, "MyThread-4");
		td4.start();

		TimeUnit.MILLISECONDS.sleep(3000);
		
		System.out.println("[" + currentTheadName + "] Interrrupting " + td1.getName() + ".......");
		td1.interrupt();

		System.out.println("[" + currentTheadName + "] Interrrupting " + td2.getName() + ".......");
		td2.interrupt();
		System.out.println("[" + currentTheadName + "] Interrrupting " + td3.getName() + ".......");
		td3.interrupt();
		
		System.out.println("[" + currentTheadName + "] Interrrupting " + td4.getName() + ".......");
		td4.interrupt();

		System.out.println("[" + currentTheadName + "] main thread ends here...");

	}

}
