package com.techleads.app.returningval1;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable {

	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	
	private static int count=0;
	private int instanceNumber;
	private String taskId;

	private volatile boolean done=false;

	public ValueReturningTaskA(int a, int b, long sleepTime) {
		super();
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		this.instanceNumber= ++count;
		this.taskId="ValueReturningTaskA-"+instanceNumber;
	}


	@Override
	public void run() {

		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> STARTING #####");
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sum=a+b;
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> COMPLETED #####");
		done=true;
		synchronized (this) {
			System.out.println("{" + Thread.currentThread().getName() + "} Notifying with Id: " + taskId + "...");
			this.notify();
		}
	}
	
	public int getSum() {
		synchronized (this) {
			if(!done) {
				try {
					System.out.println("{" + Thread.currentThread().getName() + "} Waiting for the result from " + taskId + "...");
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		return sum;
	}

}
