package com.example.demo.mapper;

import com.example.demo.domain.diary_linked_user.DiaryLinkedUser;
import com.example.demo.infrastructure.exchange.request.RegisterReplyRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ExchangeCommandMapperクラス.
 */
@Mapper
public interface ExchangeCommandMapper {

  /**
   * コメント投稿.
   *
   * @param diaryId 日記ID
   * @param commentFrom コメント元
   * @param comment コメント内容
   */
  int insertComment(
      @Param("diaryId") Integer diaryId,
      @Param("commentFrom") Integer commentFrom,
      @Param("comment") String comment);

  /**
   * コメント返信.
   *
   * @param commentId コメントID
   * @param replyFrom 返信元
   * @param replyComment 返信内容
   */
  int insertReply(
      @Param("commentId") Integer commentId,
      @Param("replyFrom") Integer replyFrom,
      @Param("replyComment") String replyComment);
}