package com.example.demo.application.exchange.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FindReplyDto {

  private Integer diaryId;

  private Integer commentNo;

  private Integer commentFrom;

  private Integer replyNo;

  private Integer replyTo;

  private Integer replyFrom;

  private String content;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
