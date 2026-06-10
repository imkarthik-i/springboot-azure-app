package com.wip.azsprdemopr.exception;

public class EmployeeNotFoundException extends RuntimeException{

	String resourceName;
	String field;
	Long fieldId;
	String fieldValue;
	public EmployeeNotFoundException(String message) {
		super(message);
		
	}

	public EmployeeNotFoundException(String resourceName, String field, Long fieldId) {
		super(String.format("%s not found with %s : %d", resourceName,field,fieldId));
		this.resourceName = resourceName;
		this.field = field;
		this.fieldId = fieldId;
	}

	public EmployeeNotFoundException(String resourceName, String field, String fieldValue) {
		super(String.format("%s not found with %s : %d", resourceName,field,fieldValue));
		this.resourceName = resourceName;
		this.field = field;
		this.fieldValue = fieldValue;
	}
	
	
	
	

}
