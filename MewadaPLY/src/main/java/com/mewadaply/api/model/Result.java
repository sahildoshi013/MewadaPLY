package com.mewadaply.api.model;

public class Result {
	
	private boolean isSuccess;
	private String message;
	
	Result(boolean result){
		this(result, "");
	}
	
	Result(boolean result, String message) {
		this.isSuccess = result;
		this.message = message;
	}
	
	public static Result getResult(boolean result,String message) {
		return new Result(result,message);
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
