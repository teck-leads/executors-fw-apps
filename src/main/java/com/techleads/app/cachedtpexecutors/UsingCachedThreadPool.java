package com.techleads.app.cachedtpexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCachedThreadPool {

	public static void main(String[] args) {
		
		System.out.println("Main thread starts here...");
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		
//		for(int i=0;i<3;i++) {
		for(int i=0;i<6;i++) {
			newCachedThreadPool.execute(new LoopTaskA());
		}
		newCachedThreadPool.shutdown();
//		newCachedThreadPool.execute(new LoopTaskA());
		
		System.out.println("Main thread ends here...");

	}

}
