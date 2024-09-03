package com.Xr.Management.exception;

/**
 * EntityNotFoundException is used to entity not found.
 */
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String error;

	public EntityNotFoundException(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
