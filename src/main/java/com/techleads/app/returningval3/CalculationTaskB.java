package com.techleads.app.returningval3;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskB implements Callable<TaskResult<String, Integer>> {

	private int a;
	private int b;
	private long sleepTime;
	
	private static int count=0;
	private int instanceNumber;
	private String taskId;


	public CalculationTaskB(int a, int b, long sleepTime) {
		super();
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		this.instanceNumber= ++count;
		this.taskId="CalculationTaskB-"+instanceNumber;
	}


	


	@Override
	public TaskResult<String, Integer> call() throws Exception {
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> STARTING #####");
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> COMPLETED #####");
		return new TaskResult<>(taskId, (a+b));
	}
	
	

}
