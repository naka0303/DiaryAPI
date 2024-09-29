package com.example.demo.infrastructure.exchange.service;

import com.example.demo.infrastructure.exchange.repository.ExchangeCommandRepository;
import com.example.demo.infrastructure.exchange.request.RegisterCommentRequest;
import com.example.demo.infrastructure.exchange.request.RegisterReplyRequest;
import org.springframework.stereotype.Service;

/**
 * ExchangeCommandServiceImplクラス.
 */
@Service
public class ExchangeCommandServiceImpl implements ExchangeCommandService {
  
  private final ExchangeCommandRepository exchangeCommandRepository;

  public ExchangeCommandServiceImpl(ExchangeCommandRepository exchangeCommandRepository) {
    this.exchangeCommandRepository = exchangeCommandRepository;
  }

  /**
   * コメント投稿.
   *
   * @param diaryId 日記ID
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  @Override
  public void registerComment(Integer diaryId, RegisterCommentRequest request) throws Exception {
    exchangeCommandRepository.registerComment(diaryId, request);
  }

  /**
   * 返信投稿.
   *
   * @param diaryId 日記ID
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  @Override
  public void registerReply(Integer diaryId, RegisterReplyRequest request) throws Exception {
    exchangeCommandRepository.registerReply(diaryId, request);
  }
}
