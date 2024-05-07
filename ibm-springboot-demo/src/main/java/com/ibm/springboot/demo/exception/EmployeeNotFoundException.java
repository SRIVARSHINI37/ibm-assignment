package com.ibm.springboot.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3810168232391342560L;

	public EmployeeNotFoundException() {
		super();
	}
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
