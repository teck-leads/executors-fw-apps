package com.techleads.app.fiexedtpexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {

	public static void main(String[] args) {
		
		System.out.println("Main thread starts here...");
//		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(6);
		
		for(int i=0;i<6;i++) {
			newFixedThreadPool.execute(new LoopTaskA());
		}
		newFixedThreadPool.shutdown();
//		newFixedThreadPool.execute(new LoopTaskA());
		
		System.out.println("Main thread ends here...");

	}

}
