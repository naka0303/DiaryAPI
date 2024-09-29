package com.example.demo.infrastructure.exchange.repository;


import com.example.demo.infrastructure.exchange.request.RegisterCommentRequest;
import com.example.demo.infrastructure.exchange.request.RegisterReplyRequest;

/**
 * DiaryCommandRepositoryクラス.
 */
public interface ExchangeCommandRepository {

  /**
   * コメント投稿.
   *
   * @param diaryId 日記ID
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  void registerComment(
      Integer diaryId, RegisterCommentRequest request) throws Exception;

  /**
   * 返信投稿.
   *
   * @param diaryId 日記ID
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  void registerReply(
      Integer diaryId, RegisterReplyRequest request) throws Exception;
}
