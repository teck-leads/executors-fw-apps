package com.techleads.app.threadsalive;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import com.techleads.app.deamon.NamedThreadsFactory;
import com.techleads.app.returningval3.CalculationTaskA;

public class ThreadsAliveCheckUsingExecutors {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here..");

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new NamedThreadsFactory());
		Future<?> f1 = newCachedThreadPool.submit(new LoopTaskC());
		Future<Integer> f2 = newCachedThreadPool.submit(new CalculationTaskA(3, 4, 700));

		FutureTask<?> f3 = new FutureTask<Void>(new LoopTaskC(), null);
		FutureTask<Integer> f4 = new FutureTask<>(new LoopTaskC(), 999);
		FutureTask<Integer> f5 = new FutureTask<>(new CalculationTaskA(4, 5, 500));
		newCachedThreadPool.execute(f3);
		newCachedThreadPool.execute(f4);
		newCachedThreadPool.execute(f5);

		newCachedThreadPool.shutdown();

		for (int i = 1; i < 5; i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(300);
				System.out
						.println("[" + currentThreadName + "] ITR " + i + " -> is 'LoopTaskC-1' done =" + f1.isDone());
				System.out.println(
						"[" + currentThreadName + "] ITR " + i + " -> is 'CalculationTask-1' done =" + f2.isDone());
				System.out
						.println("[" + currentThreadName + "] ITR " + i + " -> is 'LoopTaskC-2' done =" + f3.isDone());
				System.out
						.println("[" + currentThreadName + "] ITR " + i + " -> is 'LoopTaskC-3' done =" + f4.isDone());
				System.out.println(
						"[" + currentThreadName + "] ITR " + i + " -> is 'CalculationTask-2' done =" + f5.isDone());
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		System.out.println("[" + currentThreadName + "] Retrieving results now ... $$$$$");
		System.out.println("[" + currentThreadName + "] 'LoopTaskC-1' result = " + f1.get());
		System.out.println("[" + currentThreadName + "] 'CalculationTask-1' result = " + f2.get());
		
		
		System.out
		.println("[" + currentThreadName + "] 'LoopTaskC-2' result =" + f3.get());
System.out
		.println("[" + currentThreadName + "] 'LoopTaskC-3' result =" + f4.get());
System.out.println(
		"[" + currentThreadName + "] 'CalculationTask-2' result =" + f5.get());

		System.out.println("[" + currentThreadName + "] Main thread ends here..");

	}

}
