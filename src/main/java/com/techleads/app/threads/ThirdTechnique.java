package com.techleads.app.threads;

import java.util.concurrent.TimeUnit;

class ThirdTask implements Runnable {
	
	private static int count=0;
	private int id;

	public ThirdTask() {
		this.id= ++count;
		new Thread(this).start();
	}

	@Override
	public void run() {

		for (int i = 10; i > 0; i--) {
			System.out.println("<" +id+ ">TICK TIKC - " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class ThirdTechnique {

	public static void main(String[] args) {
System.out.println("main thread starts here...");
		new ThirdTask();
		new ThirdTask();
		System.out.println("main thread ends here...");
	}

}
