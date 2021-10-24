package com.techleads.app.namingexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingExecutorThreads {
	
	public static void main(String[] args) {
		
		//pool-N-thread-M
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main thread starts here...");

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new NamedThreadsFactory());
		for(int i=0;i<3;i++) {
			newCachedThreadPool.execute(new LoopTaskC());
		}
		newCachedThreadPool.shutdown();
		System.out.println("[ " + currentThreadName + " ] Main thread ends here...");
	}

}
