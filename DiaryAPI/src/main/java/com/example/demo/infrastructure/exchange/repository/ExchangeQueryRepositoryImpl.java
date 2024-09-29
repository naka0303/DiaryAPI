package com.example.demo.infrastructure.exchange.repository;

import com.example.demo.application.exchange.dto.FindCommentReplyLinkedUserDto;
import com.example.demo.mapper.ExchangeQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ExchangeQueryRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class ExchangeQueryRepositoryImpl implements ExchangeQueryRepository {

  private final ExchangeQueryMapper exchangeQueryMapper;

  /**
   * 指定された日記のコメントを全て取得
   *
   * @param diaryId 日記ID
   * @return コメント情報
   */
  @Override
  public List<FindCommentReplyLinkedUserDto> findCommentsReplies(Integer diaryId) {
    return exchangeQueryMapper.findCommentsReplies(diaryId);
  }
}
