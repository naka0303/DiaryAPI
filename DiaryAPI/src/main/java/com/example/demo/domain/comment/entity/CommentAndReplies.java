package com.example.demo.domain.comment.entity;

import com.example.demo.application.exchange.dto.FindCommentReplyLinkedUserDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "comments_and_replies")
@Data
public class CommentAndReplies {

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
   * @return CommentAndRepliesエンティティ
   */
  public CommentAndReplies toEntity(FindCommentReplyLinkedUserDto dto) {

    CommentAndReplies commentAndReplies = new CommentAndReplies();

    commentAndReplies.setDiaryId(dto.getDiaryId());
    commentAndReplies.setCommentNo(dto.getCommentNo());
    commentAndReplies.setCommentFrom(dto.getCommentFrom());
    commentAndReplies.setReplyNo(dto.getReplyNo());
    commentAndReplies.setReplyTo(dto.getReplyTo());
    commentAndReplies.setReplyFrom(dto.getReplyFrom());
    commentAndReplies.setContent(dto.getContent());
    commentAndReplies.setCreatedAt(dto.getCreatedAt());
    commentAndReplies.setUpdatedAt(dto.getUpdatedAt());
    commentAndReplies.setDeletedAt(dto.getDeletedAt());

    return commentAndReplies;
  }

  /**
   * エンティティリスト変換
   * @param dtoList FindCommentDtoリスト
   * @return CommentAndRepliesエンティティリスト
   */
  public List<CommentAndReplies> toEntityList(List<FindCommentReplyLinkedUserDto> dtoList) {
    List<CommentAndReplies> allCommentAndReplies = new ArrayList<>();

    for (FindCommentReplyLinkedUserDto dto : dtoList) {
      CommentAndReplies commentAndReplies = new CommentAndReplies();

      commentAndReplies.setDiaryId(dto.getDiaryId());
      commentAndReplies.setCommentNo(dto.getCommentNo());
      commentAndReplies.setCommentFrom(dto.getCommentFrom());
      commentAndReplies.setReplyNo(dto.getReplyNo());
      commentAndReplies.setReplyTo(dto.getReplyTo());
      commentAndReplies.setReplyFrom(dto.getReplyFrom());
      commentAndReplies.setContent(dto.getContent());
      commentAndReplies.setCreatedAt(dto.getCreatedAt());
      commentAndReplies.setUpdatedAt(dto.getUpdatedAt());
      commentAndReplies.setDeletedAt(dto.getDeletedAt());

      allCommentAndReplies.add(commentAndReplies);
    }

    return allCommentAndReplies;
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
