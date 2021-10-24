package com.techleads.app.cachedtpexecutors.p2;

import java.util.concurrent.ThreadFactory;

public class NamedThreadsFactory implements ThreadFactory {
	
	private static int count=0;
	private static String NAME="PoolWorker- ";

	@Override
	public Thread newThread(Runnable r) {
		
		Thread thread=new Thread(r, NAME+ ++count);
		return thread;
	}

}
