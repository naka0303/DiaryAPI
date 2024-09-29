package com.example.demo.domain.comment.entity;

import com.example.demo.application.exchange.dto.FindCommentLinkedUserDto;
import com.example.demo.application.exchange.dto.FindCommentReplyLinkedUserDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Data
public class CommentAndReplyLinkedUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "diary_id")
  private Integer diaryId;

  @Column(name = "comment_no")
  private Integer commentNo;

  @Column(name = "comment_from")
  private Integer commentFrom;

  @Column(name = "reply_no")
  private Integer replyNo;

  @Column(name = "reply_to")
  private Integer replyTo;

  @Column(name = "reply_from")
  private Integer replyFrom;

  @Column(name = "content")
  private String content;

  @NotNull
  @NotBlank
  @Column(name = "username")
  private String username;

  @NotNull
  @NotBlank
  @Column(name = "age")
  private Integer age;

  @NotNull
  @NotBlank
  @Column(name = "email")
  private String email;

  @Column(name = "created_at")
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Tokyo")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Tokyo")
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Tokyo")
  private LocalDateTime deletedAt;

  /**
   * エンティティ変換
   * @param dto FindCommentLinkedUserDto
   * @return CommentLinkedUserエンティティ
   */
  public CommentAndReplyLinkedUser toEntity(FindCommentReplyLinkedUserDto dto) {

    CommentAndReplyLinkedUser commentAndReplyLinkedUser = new CommentAndReplyLinkedUser();

    commentAndReplyLinkedUser.setDiaryId(dto.getDiaryId());
    commentAndReplyLinkedUser.setCommentNo(dto.getCommentNo());
    commentAndReplyLinkedUser.setCommentFrom(dto.getCommentFrom());
    commentAndReplyLinkedUser.setReplyNo(dto.getReplyNo());
    commentAndReplyLinkedUser.setReplyTo(dto.getReplyTo());
    commentAndReplyLinkedUser.setReplyFrom(dto.getReplyFrom());
    commentAndReplyLinkedUser.setContent(dto.getContent());
    commentAndReplyLinkedUser.setUsername(dto.getUsername());
    commentAndReplyLinkedUser.setAge(dto.getAge());
    commentAndReplyLinkedUser.setEmail(dto.getEmail());
    commentAndReplyLinkedUser.setCreatedAt(dto.getCreatedAt());
    commentAndReplyLinkedUser.setUpdatedAt(dto.getUpdatedAt());
    commentAndReplyLinkedUser.setDeletedAt(dto.getDeletedAt());

    return commentAndReplyLinkedUser;
  }

  /**
   * エンティティリスト変換
   * @param dtoList FindCommentLinkedUserDtoリスト
   * @return CommentLinkedUserエンティティリスト
   */
  public List<CommentAndReplyLinkedUser> toEntityList(List<FindCommentReplyLinkedUserDto> dtoList) {
    List<CommentAndReplyLinkedUser> allCommentAndReplyLinkedUser = new ArrayList<>();

    for (FindCommentReplyLinkedUserDto dto : dtoList) {
      CommentAndReplyLinkedUser commentAndReplyLinkedUser = new CommentAndReplyLinkedUser();

      commentAndReplyLinkedUser.setDiaryId(dto.getDiaryId());
      commentAndReplyLinkedUser.setCommentNo(dto.getCommentNo());
      commentAndReplyLinkedUser.setCommentFrom(dto.getCommentFrom());
      commentAndReplyLinkedUser.setReplyNo(dto.getReplyNo());
      commentAndReplyLinkedUser.setReplyTo(dto.getReplyTo());
      commentAndReplyLinkedUser.setReplyFrom(dto.getReplyFrom());
      commentAndReplyLinkedUser.setContent(dto.getContent());
      commentAndReplyLinkedUser.setUsername(dto.getUsername());
      commentAndReplyLinkedUser.setAge(dto.getAge());
      commentAndReplyLinkedUser.setEmail(dto.getEmail());
      commentAndReplyLinkedUser.setCreatedAt(dto.getCreatedAt());
      commentAndReplyLinkedUser.setUpdatedAt(dto.getUpdatedAt());
      commentAndReplyLinkedUser.setDeletedAt(dto.getDeletedAt());

      allCommentAndReplyLinkedUser.add(commentAndReplyLinkedUser);
    }

    return allCommentAndReplyLinkedUser;
  }

  /**
   * 投稿日時の昇順にソート
   * @return 投稿コメントリスト
   */
  public List<FindCommentReplyLinkedUserDto> sort(List<FindCommentReplyLinkedUserDto> commentList) {
    return commentList.stream().sorted(
        Comparator.comparing(FindCommentReplyLinkedUserDto::getCreatedAt)).toList();
  }
}
