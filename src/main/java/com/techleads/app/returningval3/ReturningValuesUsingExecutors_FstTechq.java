package com.techleads.app.returningval3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.techleads.app.cachedtpexecutors.LoopTaskA;
import com.techleads.app.namingexecutors.NamedThreadsFactory;

public class ReturningValuesUsingExecutors_FstTechq {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main thread starts here...");

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new NamedThreadsFactory());
		

		Future<Integer> res1 = newCachedThreadPool.submit(new CalculationTaskA(2,  3, 2000));
		Future<Integer> res2 = newCachedThreadPool.submit(new CalculationTaskA(3,  4, 1000));
		Future<Integer> res3 = newCachedThreadPool.submit(new CalculationTaskA(4,  5, 500));
		
		
		Future<?> res4 = newCachedThreadPool.submit(new LoopTaskA());
		Future<Double> res5 = newCachedThreadPool.submit(new LoopTaskA(), 999.888);
		
		
		
		try {
			System.out.println("Result-1: "+res1.get());
			System.out.println("Result-2: "+res2.get());
			System.out.println("Result-3: "+res3.get());
			System.out.println("Result-4: "+res4.get());
			System.out.println("Result-5: "+res5.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		newCachedThreadPool.shutdown();
		
		System.out.println("[ " + currentThreadName + " ] Main thread ends here...");

	}

}
