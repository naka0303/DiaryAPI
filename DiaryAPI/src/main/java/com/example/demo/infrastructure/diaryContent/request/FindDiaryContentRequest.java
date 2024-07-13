package com.example.demo.infrastructure.diaryContent.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FindDiaryContentRequest {

  @NotNull
  private Integer diaryId;
}
