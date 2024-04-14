package com.nsd.company.Exceptions;

/**
 * @author Nilesh Dhawale
 * @since 08-April-2024
 * @version 1.0
 */
public class CompanyException extends Exception {

	private static final long serialVersionUID = 1L;

	public CompanyException() {
	}

	public CompanyException(String message) {
		super(message);
	}

	public CompanyException(String message, Throwable couse) {
		super(message, couse);
	}

	public CompanyException(String resourceName, String fieldName, Integer fieldVaue) {
		super(String.format("%s not found with the given %s : %s", resourceName, fieldName, fieldVaue));
	}
}
