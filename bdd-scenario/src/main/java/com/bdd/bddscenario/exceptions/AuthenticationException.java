package com.bdd.bddscenario.exceptions;

public class AuthenticationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public AuthenticationException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
