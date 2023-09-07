package com.me.exception;

public class CookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1631823366296521859L;

	public CookNotFoundException() {
	}

	public CookNotFoundException(String message) {
		super(message);
	}
}