package com.example.demo.advice;

import lombok.Data;

@Data
public class ApiError {
	
	private Integer code;
	private String message;
	private String path;
	
	public ApiError(Integer code, String message, String path) {
		this.code = code;
		this.message = message;
		this.path = path;
	}
}
