package com.example.demo.infrastructure.diaries.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * RegisterDiaryRequestクラス.
 */
@Data
public class RegisterDiaryRequest {
  
  @NotNull
  private Integer userId;
  
  @NotNull
  @NotBlank
  private String diaryTitle;
  
  @NotNull
  @NotBlank
  private String diaryContent;
}
