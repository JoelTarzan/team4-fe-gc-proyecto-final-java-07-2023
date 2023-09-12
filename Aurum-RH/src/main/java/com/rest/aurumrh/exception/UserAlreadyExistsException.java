package com.rest.aurumrh.exception;

public class UserAlreadyExistsException extends RuntimeException {
	
	private final int httpStatusCode;

	public UserAlreadyExistsException(String message, int httpStatusCode) {
		super(message);
		this.httpStatusCode = httpStatusCode;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}
}