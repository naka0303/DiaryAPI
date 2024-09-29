package com.example.demo.mapper;

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
   * @param commentNo コメント番号
   * @param commentFrom コメント元
   * @param comment コメント内容
   */
  int insertComment(
      @Param("diaryId") Integer diaryId,
      @Param("commentNo") Integer commentNo,
      @Param("commentFrom") Integer commentFrom,
      @Param("content") String comment);

  /**
   * 返信投稿.
   *
   * @param diaryId 日記ID
   * @param replyNo 返信番号
   * @param replyTo 返信先
   * @param replyFrom 返信元
   * @param content 返信内容
   */
  int insertReply(
      @Param("diaryId") Integer diaryId,
      @Param("replyNo") Integer replyNo,
      @Param("replyTo") Integer replyTo,
      @Param("replyFrom") Integer replyFrom,
      @Param("content") String content);
}