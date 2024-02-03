package com.example.demo.application.users.dto;

import com.example.demo.domain.users.entity.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FindUsersDto {

	private Integer userId;

	private String username;

	private Integer age;

	private String email;

	private String auth;

	private Integer diaryId;

	public FindUsersDto(
			Integer userId,
			String username,
			Integer age,
			String email,
			String auth,
			Integer diaryId) {
		this.userId = userId;
		this.username = username;
		this.age = age;
		this.email = email;
		this.auth = auth;
		this.diaryId = diaryId;
	}

	public static FindUsersDto toDto(Users users) {
		FindUsersDto dto = new FindUsersDto();
		dto.setUserId(users.getUserId());
		dto.setUsername(users.getUsername());
		dto.setAge(users.getAge());
		dto.setEmail(users.getEmail());
		dto.setAuth(users.getAuth());
		dto.setUserId(users.getUserId());
		dto.setDiaryId(users.getDiaryId());
		return dto;
	}
}
