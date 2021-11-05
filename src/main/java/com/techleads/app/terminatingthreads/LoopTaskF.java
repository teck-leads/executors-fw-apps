package com.techleads.app.terminatingthreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class LoopTaskF implements Runnable{
	private static int count=0;
	private int instanceNumber;
	private String taskId;
	private final int DATASET_SIZE=100000;

	@Override
	public void run() {
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> STARTING #####");
		for (int i = 1; ; i++) {
			System.out.println("#### [" + Thread.currentThread().getName() + "] <" +taskId+ ">TICK TICK - " + i);
			doComplexCalculation();
			if(Thread.interrupted()) {
				System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> Interupted cancelling.. #####");
				break;
			}
		}
		
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> Retrieving Interupted status again " +Thread.interrupted());
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> COMPLETED #####");
		
	}
	
	private void doComplexCalculation() {
		for(int i=0;i<2; i++) {
			Collections.sort(generateDataSet());
		}
	}

	private List<Integer> generateDataSet() {
		List<Integer> inList=new ArrayList<>();
		Random random=new Random();
		for(int i=0;i<DATASET_SIZE;i++) {
			inList.add(random.nextInt(DATASET_SIZE));
		}
		return inList;
	}

	public LoopTaskF() {
		this.instanceNumber=++count;
		this.taskId="LoopTask "+instanceNumber;
	}
	

}
