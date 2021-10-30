package com.techleads.app.returningval3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.techleads.app.cachedtpexecutors.LoopTaskA;
import com.techleads.app.namingexecutors.NamedThreadsFactory;

public class ReturningValuesUsingExecutors_2ndTechq {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main thread starts here...");

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new NamedThreadsFactory());

		ExecutorCompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(
				newCachedThreadPool);

		executorCompletionService.submit(new CalculationTaskA(2, 3, 2000));
		executorCompletionService.submit(new CalculationTaskA(3, 4, 1000));
		executorCompletionService.submit(new CalculationTaskA(4, 5, 500));

		executorCompletionService.submit(new LoopTaskA(), 999);

		for (int i = 0; i < 4; i++) {
			try {
				System.out.println("Reslt = " + executorCompletionService.take().get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		newCachedThreadPool.shutdown();

		System.out.println("[ " + currentThreadName + " ] Main thread ends here...");

	}

}
