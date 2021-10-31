package com.techleads.app.deamon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeamonThreadsUsingExecutors {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main thread starts here...");

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new NamedDeamonThreadFactory());
		newCachedThreadPool.execute(new LoopTaskD(100));
		newCachedThreadPool.execute(new LoopTaskD(200));
		newCachedThreadPool.execute(new LoopTaskD(300));
		newCachedThreadPool.execute(new LoopTaskD(400));
		
		
		
		
		newCachedThreadPool.shutdown();

		System.out.println("[ " + currentThreadName + " ] Main thread ends here...");

	}

}
