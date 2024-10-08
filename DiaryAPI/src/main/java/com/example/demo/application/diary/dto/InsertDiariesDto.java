package com.example.demo.application.diary.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertDiariesDto {
	
	private Integer diaryId;
	
	private Integer userId;
	
	private String diaryTitle;
	
	private String diaryContent;
}
