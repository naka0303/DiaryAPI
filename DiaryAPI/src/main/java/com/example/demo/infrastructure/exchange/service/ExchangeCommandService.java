package com.example.demo.infrastructure.exchange.service;

import com.example.demo.infrastructure.exchange.request.RegisterCommentRequest;
import org.springframework.stereotype.Service;

/**
 * DiaryCommandServiceクラス.
 */
@Service
public interface ExchangeCommandService {

  /**
   * コメント投稿.
   * @param diaryId 日記ID
   * @param request コメント登録内容
   * @throws Exception 例外処理
   */
  void registerComment(
      Integer diaryId, RegisterCommentRequest request) throws Exception;
}
