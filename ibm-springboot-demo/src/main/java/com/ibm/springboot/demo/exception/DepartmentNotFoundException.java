package com.ibm.springboot.demo.exception;

public class DepartmentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -1865321918170527569L;

	public DepartmentNotFoundException() {
		super();
	}
	
	public DepartmentNotFoundException(String message) {
		super(message);
	}

}
