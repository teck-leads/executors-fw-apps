package com.techleads.app.namingthreads2;

import java.util.concurrent.TimeUnit;

public class LoopTaskC implements Runnable{
	private static int count=0;
	private int instanceNumber;
	private String taskId;

	@Override
	public void run() {
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> STARTING #####");
		for (int i = 10; i > 0; i--) {
			System.out.println("#### [" + Thread.currentThread().getName() + "] <" +taskId+ ">TICK TICK - " + i);
			try {
				TimeUnit.MILLISECONDS.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> COMPLETED #####");
		
	}

	public LoopTaskC() {
		this.instanceNumber=++count;
		this.taskId="LoopTaskC "+instanceNumber;
	}
	

}
