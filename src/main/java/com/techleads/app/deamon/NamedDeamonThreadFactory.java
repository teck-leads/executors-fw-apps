package com.techleads.app.deamon;

public class NamedDeamonThreadFactory extends NamedThreadsFactory{
	private static int count=0;
	@Override
	public Thread newThread(Runnable r) {
		Thread t=super.newThread(r);
		if(++count %2 ==0) {
			t.setDaemon(true);
		}
		return t;
	}

}
