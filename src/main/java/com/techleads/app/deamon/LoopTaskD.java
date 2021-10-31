package com.techleads.app.deamon;

import java.util.concurrent.TimeUnit;

public class LoopTaskD implements Runnable{
	private static int count=0;
	private int instanceNumber;
	private String taskId;
	private long sleepTime;

	@Override
	public void run() {
		boolean isRunningDaemonThread=Thread.currentThread().isDaemon();
		String threadType=isRunningDaemonThread?"DEAMON":"USER Thread";
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> STARTING #####");
		for (int i = 10; i > 0; i--) {
			System.out.println("#### [" + Thread.currentThread().getName() + ", "+threadType+" ] <" +taskId+ ">TICK TICK - " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#### [" + Thread.currentThread().getName() + ", "+threadType + " ] <TASK-" + taskId + "> COMPLETED #####");
		
	}

	public LoopTaskD(long sleepTime) {
		this.instanceNumber=++count;
		this.taskId="LoopTaskD "+instanceNumber;
		this.sleepTime=sleepTime;
	}
	

}
