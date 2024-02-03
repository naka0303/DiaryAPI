package com.example.demo.application.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InsertUsersDto {

	private String username;

	private Integer age;

	private String email;
	
	private String password;

	private String auth;

	public InsertUsersDto(
			String username,
			Integer age,
			String email,
			String password,
			String auth) {
		this.username = username;
		this.age = age;
		this.email = email;
		this.password = password;
		this.auth = auth;
	}
}
