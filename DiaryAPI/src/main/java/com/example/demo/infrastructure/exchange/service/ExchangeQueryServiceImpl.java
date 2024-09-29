package com.example.demo.infrastructure.exchange.service;

import com.example.demo.application.exchange.dto.FindCommentLinkedUserDto;
import com.example.demo.application.exchange.dto.FindCommentReplyLinkedUserDto;
import com.example.demo.infrastructure.exchange.repository.ExchangeQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ExchangeQueryServiceImplクラス.
 */
@Service
public class ExchangeQueryServiceImpl implements ExchangeQueryService {

  private final ExchangeQueryRepository exchangeQueryRepository;
  
  public ExchangeQueryServiceImpl(
      ExchangeQueryRepository exchangeQueryRepository) {
      this.exchangeQueryRepository = exchangeQueryRepository;
  }

  /**
   * 指定された日記のコメントを全て取得.
   *
   * @param diaryId 日記ID
   * @return コメント情報
   */
  @Override
  public List<FindCommentReplyLinkedUserDto> findCommentsReplies(Integer diaryId) {
    return exchangeQueryRepository.findCommentsReplies(diaryId);
  }
}
