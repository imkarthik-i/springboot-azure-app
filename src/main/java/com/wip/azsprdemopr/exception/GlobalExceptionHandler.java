package com.wip.azsprdemopr.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<APIResponse> empNotFound(EmployeeNotFoundException ex) {
		String message = ex.getMessage();
		APIResponse apiResponse = new APIResponse(message);

		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,Object>> argNotValid(MethodArgumentNotValidException ex){
		Map<String,Object> response = new HashMap<String, Object>();
		
		ex.getBindingResult().getFieldErrors().forEach(
				errors ->{
					response.put(errors.getField(), errors.getDefaultMessage());
				}	
				);
		
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	}

}
