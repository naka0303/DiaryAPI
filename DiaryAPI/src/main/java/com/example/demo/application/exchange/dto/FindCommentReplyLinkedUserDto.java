package com.example.demo.application.exchange.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FindCommentReplyLinkedUserDto {

  private Integer diaryId;

  private Integer commentNo;

  private Integer commentFrom;

  private Integer replyNo;

  private Integer replyTo;

  private Integer replyFrom;

  private String username;

  private Integer age;

  private String email;

  private String content;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;
}
