package com.cg.marriageceremony.response;

public class ExceptionResponse {

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionResponse(String message) {
		super();
		this.message = message;
	}

	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

}
