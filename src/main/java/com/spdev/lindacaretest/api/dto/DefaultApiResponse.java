package com.spdev.lindacaretest.api.dto;

import java.io.Serializable;

/**
 * Default Api response
 * 
 * @author marco
 *
 */
public class DefaultApiResponse implements Serializable {

	private static final long serialVersionUID = 2983433715563810630L;

	private String message;

	public DefaultApiResponse() {
		super();
		this.message = "No error";
	}

	public DefaultApiResponse(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
