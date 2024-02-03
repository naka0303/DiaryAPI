package com.example.demo.domain.diariesContents.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DiariesContents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diary_id")
	private Integer diaryId;
	
	@Column(name = "diary_title")
	private String diaryTitle;
	
	@Column(name = "diary_content")
	private String diaryContent;
	
	@Column(name = "user_id")
	private Integer userId;
}
