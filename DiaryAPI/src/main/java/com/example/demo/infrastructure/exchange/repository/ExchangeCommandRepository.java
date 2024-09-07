package com.example.demo.infrastructure.exchange.repository;

import com.example.demo.infrastructure.exchange.request.RegisterCommentRequest;

/**
 * DiaryCommandRepositoryクラス.
 */
public interface ExchangeCommandRepository {

  /**
   * コメント投稿.
   *
   * @param diaryId 日記ID
   * @param request コメント登録内容
   * @throws Exception 例外処理
   */
  void registerComment(
      Integer diaryId, RegisterCommentRequest request) throws Exception;
}
