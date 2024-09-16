package com.example.demo.infrastructure.exchange.service;

import com.example.demo.infrastructure.exchange.request.RegisterCommentRequest;
import com.example.demo.infrastructure.exchange.request.RegisterReplyRequest;
import org.springframework.stereotype.Service;

/**
 * DiaryCommandServiceクラス.
 */
@Service
public interface ExchangeCommandService {

  /**
   * コメント投稿.
   * @param diaryId 日記ID
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  void registerComment(
      Integer diaryId, RegisterCommentRequest request) throws Exception;

  /**
   * コメント返信.
   * @param diaryId 日記ID
   * @param commentId コメントID
   * @param request 登録内容
   */
  void registerReply(
      Integer diaryId, Integer commentId, RegisterReplyRequest request) throws Exception;
}
