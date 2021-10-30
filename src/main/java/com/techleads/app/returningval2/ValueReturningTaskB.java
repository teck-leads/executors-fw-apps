package com.techleads.app.returningval2;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable {

	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	
	private static int count=0;
	private int instanceNumber;
	private String taskId;

	private ResultListener<Integer> resultListener;

	public ValueReturningTaskB(int a, int b, long sleepTime,  ResultListener<Integer> resultListener) {
		super();
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		this.resultListener=resultListener;
		this.instanceNumber= ++count;
		this.taskId="ValueReturningTaskB-"+instanceNumber;
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
		resultListener.notifyResult(sum);
		
	}
	
	

}
