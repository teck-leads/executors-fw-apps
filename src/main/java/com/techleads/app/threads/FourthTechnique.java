package com.techleads.app.threads;

import java.util.concurrent.TimeUnit;

class FourthTask implements Runnable {

	private static int count = 0;
	private int id;

	public FourthTask() {
		this.id = ++count;
	}

	@Override
	public void run() {

		for (int i = 10; i > 0; i--) {
			System.out.println("<" + id + ">TICK TIKC - " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class FourthTechnique {

	public static void main(String[] args) {
		System.out.println("main thread starts here...");

		new Thread(new FourthTask()).start();
		Thread t = new Thread(new FourthTask());
		t.start();
	
		System.out.println("main thread ends here...");
	}

}
