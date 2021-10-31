package com.techleads.app.threadsalive;

import java.util.concurrent.TimeUnit;

public class ThreadsAliveCheck {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here..");

		Thread t1 = new Thread(new LoopTaskC(), "MyThread-1");
		Thread t2 = new Thread(new LoopTaskC(), "MyThread-2");

		boolean t1Alive = t1.isAlive();
		boolean t2Alive = t2.isAlive();

		System.out.println("[" + currentThreadName + "] Before starting is " + t1.getName() + " alive = " + t1Alive);
		System.out.println("[" + currentThreadName + "] Before starting is " + t2.getName() + " alive = " + t2Alive);

		t1.start();
		t2.start();
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(600);
				t1Alive = t1.isAlive();
				t2Alive = t2.isAlive();
				System.out.println(
						"[" + currentThreadName + "] is " + t1.getName() + " alive = " + t1Alive);
				System.out.println(
						"[" + currentThreadName + "] is " + t2.getName() + " alive = " + t2Alive);

				if (!t1Alive && !t2Alive) {
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("[" + currentThreadName + "] Main thread ends here..");

	}

}
