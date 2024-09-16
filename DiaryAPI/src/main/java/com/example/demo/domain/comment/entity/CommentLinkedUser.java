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
  @NotNull
  @Column(name = "comment_id")
  private Integer commentId;

  @NotNull
  @Column(name = "diary_id")
  private Integer diaryId;

  @NotNull
  @Column(name = "comment_from")
  private Integer commentFrom;

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

  @NotNull
  @Column(name = "comment")
  private String comment;

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

    commentLinkedUser.setCommentId(dto.getCommentId());
    commentLinkedUser.setDiaryId(dto.getDiaryId());
    commentLinkedUser.setCommentFrom(dto.getCommentFrom());
    commentLinkedUser.setUsername(dto.getUsername());
    commentLinkedUser.setAge(dto.getAge());
    commentLinkedUser.setEmail(dto.getEmail());
    commentLinkedUser.setComment(dto.getComment());
    commentLinkedUser.setCreatedAt(dto.getCreatedAt());
    commentLinkedUser.setUpdatedAt(dto.getUpdatedAt());
    commentLinkedUser.setDeletedAt(dto.getDeletedAt());

    return commentLinkedUser;
  }

  /**
   * エンティティリスト変換
   * @param dtoList FindCommentDtoリスト
   * @return CommentLinkedUserエンティティリスト
   */
  public List<CommentLinkedUser> toEntityList(List<FindCommentLinkedUserDto> dtoList) {
    List<CommentLinkedUser> commentLinkedUserList = new ArrayList<>();

    for (FindCommentLinkedUserDto dto : dtoList) {
      CommentLinkedUser commentLinkedUser = new CommentLinkedUser();

      commentLinkedUser.setCommentId(dto.getCommentId());
      commentLinkedUser.setDiaryId(dto.getDiaryId());
      commentLinkedUser.setCommentFrom(dto.getCommentFrom());
      commentLinkedUser.setUsername(dto.getUsername());
      commentLinkedUser.setAge(dto.getAge());
      commentLinkedUser.setEmail(dto.getEmail());
      commentLinkedUser.setComment(dto.getComment());
      commentLinkedUser.setCreatedAt(dto.getCreatedAt());
      commentLinkedUser.setUpdatedAt(dto.getUpdatedAt());
      commentLinkedUser.setDeletedAt(dto.getDeletedAt());

      commentLinkedUserList.add(commentLinkedUser);
    }

    return commentLinkedUserList;
  }

  /**
   * 投稿日時の昇順にソート
   * @return 投稿コメントリスト
   */
  public List<FindCommentLinkedUserDto> sort(List<FindCommentLinkedUserDto> commentList) {
    return commentList.stream().sorted(Comparator.comparing(FindCommentLinkedUserDto::getCreatedAt)).toList();
  }
}
