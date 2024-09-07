package com.example.demo.infrastructure.exchange.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * RegisterCommentRequestクラス.
 */
@Data
public class RegisterCommentRequest {

  @NotNull
  private Integer userId;

  @NotNull
  @NotBlank
  private String comment;
}
