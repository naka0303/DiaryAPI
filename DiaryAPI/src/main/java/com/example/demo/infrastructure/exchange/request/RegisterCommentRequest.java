package com.example.demo.infrastructure.exchange.request;

import lombok.Data;

/**
 * RegisterCommentRequestクラス.
 */
@Data
public class RegisterCommentRequest {

  private Integer commentFrom;

  private String content;
}
