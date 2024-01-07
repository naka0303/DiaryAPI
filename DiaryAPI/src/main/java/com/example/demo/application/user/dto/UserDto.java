package com.example.demo.application.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Integer userId;
	
	private String username;
	
	private Integer age;
	
	private String email;
	
	private String auth;
	
}
