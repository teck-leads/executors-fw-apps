package com.techleads.app.singletpexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingSingleThreadExecutor {

	public static void main(String[] args) {
		
		System.out.println("Main thread starts here...");
	ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		
//		for(int i=0;i<3;i++) {
		for(int i=0;i<6;i++) {
			newSingleThreadExecutor.execute(new LoopTaskA());
		}                                                                                                    
		newSingleThreadExecutor.shutdown();
//		newSingleThreadExecutor.execute(new LoopTaskA());
		
		System.out.println("Main thread ends here...");

	}

}
