package com.example.demo.infrastructure.users.request;

import lombok.Data;

/**
 * EditDiaryIdRequestクラス.
 */
@Data
public class EditDiaryIdRequest {

  private Integer userId;

  private Integer diaryId;
}
