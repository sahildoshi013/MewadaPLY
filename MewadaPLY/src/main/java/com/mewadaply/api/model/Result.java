package com.mewadaply.api.model;

public class Result {
		
	private boolean status;
	private Object message;
	
	
	

	public Result(boolean status2, Object message2) {
		// TODO Auto-generated constructor stub
		this.status = status2;
		this.message = message2;
	}



	public static Result getResult(boolean status,Object message) {
		return new Result(status,message);
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public Object getMessage() {
		return message;
	}



	public void setMessage(Object message) {
		this.message = message;
	}
	
	
}
