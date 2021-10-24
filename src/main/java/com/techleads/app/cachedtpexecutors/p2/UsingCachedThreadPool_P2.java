package com.techleads.app.cachedtpexecutors.p2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.techleads.app.namingexecutors.LoopTaskC;
import com.techleads.app.namingexecutors.NamedThreadsFactory;

public class UsingCachedThreadPool_P2 {

	public static void main(String[] args) {
		
		//pool-N-thread-M
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main thread starts here...");

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new NamedThreadsFactory());
		for(int i=0;i<3;i++) {
			newCachedThreadPool.execute(new LoopTaskC());
		}
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Submitting more tasks now...");
		for(int i=0;i<5;i++) {
			newCachedThreadPool.execute(new LoopTaskC());
		}
		newCachedThreadPool.shutdown();
		System.out.println("[ " + currentThreadName + " ] Main thread ends here...");

	}

}
