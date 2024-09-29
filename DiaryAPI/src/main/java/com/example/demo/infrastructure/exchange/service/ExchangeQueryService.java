package com.example.demo.infrastructure.exchange.service;

import com.example.demo.application.exchange.dto.FindCommentReplyLinkedUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ExchangeQueryServiceクラス.
 */
@Service
public interface ExchangeQueryService {

  /**
   * 指定された日記のコメントを全て取得
   * @param diaryId 日記ID
   * @return コメント情報
   */
  List<FindCommentReplyLinkedUserDto> findCommentsReplies(Integer diaryId);
}
