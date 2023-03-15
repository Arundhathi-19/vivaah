package com.cg.marriageceremony.exceptionhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cg.marriageceremony.exceptions.FieldCannotBeEmptyException;
import com.cg.marriageceremony.exceptions.NoCustomerPresentException;
import com.cg.marriageceremony.response.ApiError;
import com.cg.marriageceremony.response.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(FieldCannotBeEmptyException.class)
	public ResponseEntity<?> handleFieldCannotBeEmptyException(FieldCannotBeEmptyException fieldCannotBeEmptyException, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(fieldCannotBeEmptyException.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoCustomerPresentException.class)
	public ResponseEntity<?> handleNoCustomerPresentException(NoCustomerPresentException noCustomerPresentException, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(noCustomerPresentException.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handle(Exception e){
		e.printStackTrace();
		ApiError error=new ApiError();
		error.setMsg(e.getMessage());
		ResponseEntity<ApiError> resEntity=new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		return resEntity;
	}
}
