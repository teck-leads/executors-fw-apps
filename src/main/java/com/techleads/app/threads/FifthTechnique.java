package com.techleads.app.threads;

import java.util.concurrent.TimeUnit;

public class FifthTechnique {

	public static void main(String[] args) {
		System.out.println("main thread starts here...");

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 10; i > 0; i--) {
					System.out.println("TICK TIKC - " + i);
					try {
						TimeUnit.MILLISECONDS.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		t.start();

		System.out.println("main thread ends here...");
	}

}
