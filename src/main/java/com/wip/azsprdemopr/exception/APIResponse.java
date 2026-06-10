package com.wip.azsprdemopr.exception;

public class APIResponse {
	private String message;
	

	public APIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public APIResponse(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	@Override
	public String toString() {
		return "APIResponse [message=" + message + "]";
	}

}
