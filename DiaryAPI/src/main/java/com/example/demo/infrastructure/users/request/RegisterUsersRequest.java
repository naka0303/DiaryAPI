package com.example.demo.infrastructure.users.request;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUsersRequest {
	
	@NonNull
	@NotBlank
	private String username;

	@NonNull
	private Integer age;

	@NonNull
	@NotBlank
	private String email;
	
	@NonNull
	@NotBlank
	private String password;

	@NonNull
	@NotBlank
	private String auth;
}
