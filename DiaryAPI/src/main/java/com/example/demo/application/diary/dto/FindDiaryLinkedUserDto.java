package com.example.demo.application.diary.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FindDiaryLinkedUserDto {

  private Integer diaryId;

  private String diaryTitle;

  private String diaryContent;

  private Integer userId;

  private String username;

  private Integer age;

  private String email;

  private String auth;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
