package com.example.demo.infrastructure.diaryContent.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * RegisterDiaryContentRequestクラス.
 */
@Data
public class RegisterDiaryContentRequest {

  @NotNull
  private Integer userId;

  @NotNull
  @NotBlank
  private String diaryTitle;
  
  @NotNull
  @NotBlank
  private String diaryContent;
}
