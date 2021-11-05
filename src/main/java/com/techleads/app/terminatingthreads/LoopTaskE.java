package com.techleads.app.terminatingthreads;

import java.util.concurrent.TimeUnit;

public class LoopTaskE implements Runnable{
	private static int count=0;
	private int instanceNumber;
	private String taskId;
	private volatile boolean shutdown=false;

	@Override
	public void run() {
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> STARTING #####");
		for (int i = 1; ; i++) {
			System.out.println("#### [" + Thread.currentThread().getName() + "] <" +taskId+ ">TICK TICK - " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(((long)Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (this) {
				if(shutdown) {
					break;
				}
				
			}
		}
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> COMPLETED #####");
//		
		
	}
	
	public void cancel() {
		System.out.println("#### [" + Thread.currentThread().getName() +" ] <TASK-" + taskId + "> Shutting down #####");
		synchronized (this) {
			this.shutdown=true;
			
		}
	}

	public LoopTaskE() {
		this.instanceNumber=++count;
		this.taskId="LoopTaskE "+instanceNumber;
	}
	

}
