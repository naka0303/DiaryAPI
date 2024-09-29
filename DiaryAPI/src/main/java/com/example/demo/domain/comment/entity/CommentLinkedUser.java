package com.example.demo.domain.comment.entity;

import com.example.demo.application.exchange.dto.FindCommentLinkedUserDto;
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
public class CommentLinkedUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "diary_id")
  private Integer diaryId;

  @Column(name = "comment_no")
  private Integer commentNo;

  @Column(name = "comment_from")
  private Integer commentFrom;

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
  public CommentLinkedUser toEntity(FindCommentLinkedUserDto dto) {

    CommentLinkedUser commentLinkedUser = new CommentLinkedUser();

    commentLinkedUser.setDiaryId(dto.getDiaryId());
    commentLinkedUser.setCommentNo(dto.getCommentNo());
    commentLinkedUser.setCommentFrom(dto.getCommentFrom());
    commentLinkedUser.setContent(dto.getContent());
    commentLinkedUser.setUsername(dto.getUsername());
    commentLinkedUser.setAge(dto.getAge());
    commentLinkedUser.setEmail(dto.getEmail());
    commentLinkedUser.setCreatedAt(dto.getCreatedAt());
    commentLinkedUser.setUpdatedAt(dto.getUpdatedAt());
    commentLinkedUser.setDeletedAt(dto.getDeletedAt());

    return commentLinkedUser;
  }

  /**
   * エンティティリスト変換
   * @param dtoList FindCommentLinkedUserDtoリスト
   * @return CommentLinkedUserエンティティリスト
   */
  public List<CommentLinkedUser> toEntityList(List<FindCommentLinkedUserDto> dtoList) {
    List<CommentLinkedUser> allCommentLinkedUser = new ArrayList<>();

    for (FindCommentLinkedUserDto dto : dtoList) {
      CommentLinkedUser commentLinkedUser = new CommentLinkedUser();

      commentLinkedUser.setDiaryId(dto.getDiaryId());
      commentLinkedUser.setCommentNo(dto.getCommentNo());
      commentLinkedUser.setCommentFrom(dto.getCommentFrom());
      commentLinkedUser.setContent(dto.getContent());
      commentLinkedUser.setUsername(dto.getUsername());
      commentLinkedUser.setAge(dto.getAge());
      commentLinkedUser.setEmail(dto.getEmail());
      commentLinkedUser.setCreatedAt(dto.getCreatedAt());
      commentLinkedUser.setUpdatedAt(dto.getUpdatedAt());
      commentLinkedUser.setDeletedAt(dto.getDeletedAt());

      allCommentLinkedUser.add(commentLinkedUser);
    }

    return allCommentLinkedUser;
  }

  /**
   * 投稿日時の昇順にソート
   * @return 投稿コメントリスト
   */
  public List<FindCommentLinkedUserDto> sort(List<FindCommentLinkedUserDto> commentList) {
    return commentList.stream().sorted(
        Comparator.comparing(FindCommentLinkedUserDto::getCreatedAt)).toList();
  }
}
