package com.mewadaply.api.model;

public class Result {
	
	private boolean status;
	private Object message;
	
	Result(boolean result){
		this(result, "");
	}
	
	Result(boolean result, Object message) {
		this.status = result;
		this.message = message;
	}
	
	public static Result getResult(boolean result,Object message) {
		return new Result(result,message);
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
