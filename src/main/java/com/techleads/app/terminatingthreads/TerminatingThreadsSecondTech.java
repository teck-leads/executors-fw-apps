package com.techleads.app.terminatingthreads;

import java.util.concurrent.TimeUnit;

public class TerminatingThreadsSecondTech {

	public static void main(String[] args) {
		String currentTheadName = Thread.currentThread().getName();
		System.out.println("[" + currentTheadName + "] main thread starts here...");

		LoopTaskF t1 = new LoopTaskF();
		LoopTaskF t2 = new LoopTaskF();
		LoopTaskF t3 = new LoopTaskF();
		Thread td1 = new Thread(t1, "MyThread-1");
		Thread td2 = new Thread(t2, "MyThread-2");
		Thread td3 = new Thread(t3, "MyThread-3");
		td1.start();
		td2.start();
		td3.start();

		try {
			TimeUnit.MICROSECONDS.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("[" + currentTheadName + "] Interrrupting " + td1.getName() + ".......");
		td1.interrupt();

		System.out.println("[" + currentTheadName + "] Interrrupting " + td2.getName() + ".......");
		td2.interrupt();
		System.out.println("[" + currentTheadName + "] Interrrupting " + td3.getName() + ".......");
		td3.interrupt();

		System.out.println("[" + currentTheadName + "] main thread ends here...");

	}

}
