package com.example.demo.application.diaryContent.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindDiaryContentDto {

  private Integer contentId;

  private Integer diaryId;

  private String diaryTitle;

  private String diaryContent;
}
