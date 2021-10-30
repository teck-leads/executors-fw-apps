package com.techleads.app.returningval2;

public class SumObserver implements ResultListener<Integer> {

	
	private String taskId;
	
	
	


	public SumObserver(String taskId) {
		super();
		this.taskId = taskId;
	}





	@Override
	public void notifyResult(Integer result) {

		System.out.println("Result for "+taskId+" = "+result);
	}

}
