package com.techleads.app.returningval2;

public class ReturningValuesSecond {
	
	public static void main(String[] args) {
		//pool-N-thread-M
				String currentThreadName = Thread.currentThread().getName();
				System.out.println("[ " + currentThreadName + " ] Main thread starts here...");

				ValueReturningTaskB tk1=new ValueReturningTaskB(2,3, 2000, new SumObserver("task-1"));
				Thread t1=new Thread(tk1, "Thread-1");
				
				
				ValueReturningTaskB tk2=new ValueReturningTaskB(3,4, 1000,new SumObserver("task-2"));
				Thread t2=new Thread(tk2, "Thread-2");
				
				ValueReturningTaskB tk3=new ValueReturningTaskB(4,5, 500,new SumObserver("task-3"));
				Thread t3=new Thread(tk3, "Thread-3");
				
				t1.start();
				t2.start();
				t3.start();
				

				
				
				System.out.println("[ " + currentThreadName + " ] Main thread ends here...");

	}

}
