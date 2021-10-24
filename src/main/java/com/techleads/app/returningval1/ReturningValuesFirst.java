package com.techleads.app.returningval1;

public class ReturningValuesFirst {
	
	public static void main(String[] args) {
		//pool-N-thread-M
				String currentThreadName = Thread.currentThread().getName();
				System.out.println("[ " + currentThreadName + " ] Main thread starts here...");

				ValueReturningTaskA tk1=new ValueReturningTaskA(2,3, 2000);
				Thread t1=new Thread(tk1, "Thread-1");
				
				
				ValueReturningTaskA tk2=new ValueReturningTaskA(3,4, 1000);
				Thread t2=new Thread(tk2, "Thread-2");
				
				ValueReturningTaskA tk3=new ValueReturningTaskA(4,5, 500);
				Thread t3=new Thread(tk3, "Thread-3");
				
				t1.start();
				t2.start();
				t3.start();
				

				System.out.println("Result-1 = "+tk1.getSum());
				System.out.println("Result-1 = "+tk2.getSum());
				System.out.println("Result-1 = "+tk3.getSum());
				
				System.out.println("[ " + currentThreadName + " ] Main thread ends here...");

	}

}
