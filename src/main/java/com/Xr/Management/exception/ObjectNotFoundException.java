package com.Xr.Management.exception;

/**
 * This class use to throw object related error
 * 
 * @author Mamta Chovatia
 *
 */
public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String error;

	public ObjectNotFoundException(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
