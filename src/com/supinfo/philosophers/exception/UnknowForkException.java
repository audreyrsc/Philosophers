package com.supinfo.philosophers.exception;

public class UnknowForkException extends RuntimeException {

	private static final long serialVersionUID = 6777566279166283031L;

	public UnknowForkException(String message) {
		super(message);
	}

}
