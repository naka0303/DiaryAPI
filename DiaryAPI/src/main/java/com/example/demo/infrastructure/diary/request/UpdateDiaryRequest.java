package com.example.demo.infrastructure.diary.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * UpdateDiaryRequestクラス.
 */
@Data
public class UpdateDiaryRequest {

  @NotNull
  @NotBlank
  private String diaryTitle;

  @NotNull
  @NotBlank
  private String diaryContent;
}
