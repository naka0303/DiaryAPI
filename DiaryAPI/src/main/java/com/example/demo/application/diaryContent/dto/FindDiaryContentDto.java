package com.example.demo.application.diaryContent.dto;

import com.example.demo.domain.contents.entity.Content;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FindDiaryContentDto {

  private Integer contentId;

  private Integer diaryId;

  private String diaryTitle;

  private String diaryContent;
}
