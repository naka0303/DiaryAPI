package com.example.demo.infrastructure.exchange.request;

import lombok.Data;

/**
 * RegisterReplyRequestクラス.
 */
@Data
public class RegisterReplyRequest {

  private Integer replyTo;

  private Integer replyFrom;

  private String content;
}
