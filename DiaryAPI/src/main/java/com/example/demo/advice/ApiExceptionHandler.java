package com.example.demo.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({NotFoundException.class})
	public ResponseEntity<Object> handlerNotFoundException(NotFoundException exception, WebRequest request) {
		
		String path = ((ServletWebRequest) request).getRequest().getRequestURI();
		ApiError apiError = new ApiError(exception.getCode(), exception.getMessage(), path);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		return handleExceptionInternal(exception, apiError, httpHeaders, HttpStatus.NOT_FOUND, request);
	}
}
