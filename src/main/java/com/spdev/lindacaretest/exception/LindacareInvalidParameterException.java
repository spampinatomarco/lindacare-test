package com.spdev.lindacaretest.exception;

/**
 * A custom exception used to return error to client when the parameter from the
 * API are invalid.
 * 
 * @author marco
 *
 */
public class LindacareInvalidParameterException extends RuntimeException {

	private static final long serialVersionUID = -8414473412062757018L;

	public LindacareInvalidParameterException(String message) {
		super(message);
	}

}
