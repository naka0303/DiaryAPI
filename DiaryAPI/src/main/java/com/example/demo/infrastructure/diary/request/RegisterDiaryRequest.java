package com.example.demo.infrastructure.diary.request;

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
  private Integer diaryId;
}
