package com.techleads.app.terminatingthreads;

import java.util.concurrent.TimeUnit;

public class LoopTaskH implements Runnable {
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	private boolean sleepInterrupted = false;

	@Override
	public void run() {
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> STARTING #####");
		for (int i = 1;; i++) {
			System.out.println("#### [" + Thread.currentThread().getName() + "] <" + taskId + ">TICK TICK - " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(((long) Math.random() * 3000));
			} catch (InterruptedException e) {
				System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId
						+ "> Sleep Interrupted. Setting the flag...");
				sleepInterrupted = true;
			}
			doSomeMoreWork();
			if (sleepInterrupted || Thread.interrupted()) {
				System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId
						+ "> Sleep Interrupted. Cancelling...");
				break;
			}
		}
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> COMPLETED #####");

	}

	private void doSomeMoreWork() {
		System.out.println("#### [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> DOING SOME MORE WORK #####");
	}

	public LoopTaskH() {
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskH " + instanceNumber;
	}

}
