package com.example.demo.mapper;

import com.example.demo.application.exchange.dto.FindCommentLinkedUserDto;
import com.example.demo.application.exchange.dto.FindCommentReplyLinkedUserDto;
import com.example.demo.application.exchange.dto.FindReplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExchangeQueryMapper {

  /**
   * 指定された日記のコメントを全て取得.
   *
   * @param diaryId 日記ID
   * @return 全コメント情報
   */
  List<FindCommentReplyLinkedUserDto> findCommentsReplies(
      @Param("diaryId") Integer diaryId);

  /**
   * 指定されたコメントを取得
   * @param diaryId 日記ID
   * @param replyTo 返信先
   * @return コメント情報
   */
  FindCommentLinkedUserDto findCommentsByComment(
      @Param("diaryId") Integer diaryId,
      @Param("replyTo") Integer replyTo);

  /**
   * 指定されたコメントの全返信を取得
   * @param diaryId 日記ID
   * @param replyTo 返信先
   */
  List<FindReplyDto> findRepliesByComment(
      @Param("diaryId") Integer diaryId,
      @Param("replyTo") Integer replyTo);
}
