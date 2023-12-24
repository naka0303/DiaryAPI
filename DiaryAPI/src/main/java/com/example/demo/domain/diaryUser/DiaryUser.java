package com.example.demo.domain.diaryUser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "diary_user")
@Data
public class DiaryUser {
	
	@Id
	private Integer userId;
	
	private String username;
	
	private Integer age;
	
	private String email;
	
	private String auth;
}