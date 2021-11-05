package com.techleads.app.terminatingthreads;

import java.util.concurrent.TimeUnit;

public class LoopTaskG implements Runnable{
	private static int count=0;
	private int instanceNumber;
	private String taskId;

	@Override
	public void run() {
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> STARTING #####");
		for (int i = 1; ; i++) {
			System.out.println("#### [" + Thread.currentThread().getName() + "] <" +taskId+ ">TICK TICK - " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(((long)Math.random()*3000));
			} catch (InterruptedException e) {
				System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> Sleep Interrupted. Cancelling...");
				break;
			}
			
		}
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> COMPLETED #####");
		
	}
	
	
	
	public LoopTaskG() {
		this.instanceNumber=++count;
		this.taskId="LoopTaskG "+instanceNumber;
	}
	
	

}
