package com.example.demo.infrastructure.contents.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * RegisterContentRequestクラス.
 */
@Data
public class RegisterContentRequest {
  
  @NotNull
  private Integer contentId;

  @NotNull
  private Integer diaryId;
  
  @NotNull
  @NotBlank
  private String diaryTitle;
  
  @NotNull
  @NotBlank
  private String diaryContent;
}
