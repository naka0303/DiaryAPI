package com.example.demo.domain.comment.entity;

import com.example.demo.application.exchange.dto.FindCommentLinkedUserDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "comments")
@Data
public class Comment {

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
   * @param dto FindCommentDto
   * @return Commentエンティティ
   */
  public Comment toEntity(FindCommentLinkedUserDto dto) {

    Comment comment = new Comment();

    comment.setCommentId(dto.getCommentId());
    comment.setDiaryId(dto.getDiaryId());
    comment.setCommentFrom(dto.getCommentFrom());
    comment.setComment(dto.getComment());
    comment.setCreatedAt(dto.getCreatedAt());
    comment.setUpdatedAt(dto.getUpdatedAt());
    comment.setDeletedAt(dto.getDeletedAt());

    return comment;
  }

  /**
   * エンティティリスト変換
   * @param dtoList FindCommentDtoリスト
   * @return Commentエンティティリスト
   */
  public List<Comment> toEntityList(List<FindCommentLinkedUserDto> dtoList) {
    List<Comment> commentList = new ArrayList<>();

    for (FindCommentLinkedUserDto dto : dtoList) {
      Comment comment = new Comment();

      comment.setCommentId(dto.getCommentId());
      comment.setDiaryId(dto.getDiaryId());
      comment.setCommentFrom(dto.getCommentFrom());
      comment.setComment(dto.getComment());
      comment.setCreatedAt(dto.getCreatedAt());
      comment.setUpdatedAt(dto.getUpdatedAt());
      comment.setDeletedAt(dto.getDeletedAt());

      commentList.add(comment);
    }

    return commentList;
  }

  /**
   * 投稿日時の昇順にソート
   * @return 投稿コメントリスト
   */
  public List<FindCommentLinkedUserDto> sort(List<FindCommentLinkedUserDto> commentList) {
    return commentList.stream().sorted(Comparator.comparing(FindCommentLinkedUserDto::getCreatedAt)).toList();
  }
}
