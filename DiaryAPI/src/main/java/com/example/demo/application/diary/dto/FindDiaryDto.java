package com.example.demo.application.diary.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FindDiaryDto {

  private Integer diaryId;

  private String diaryTitle;

  private String diaryContent;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
