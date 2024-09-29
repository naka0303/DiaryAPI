package com.example.demo.infrastructure.exchange.repository;

import com.example.demo.application.exchange.dto.FindCommentLinkedUserDto;
import com.example.demo.application.exchange.dto.FindCommentReplyLinkedUserDto;

import java.util.List;

/**
 * ExchangeQueryRepositoryクラス.
 */
public interface ExchangeQueryRepository {

    /**
     * 指定された日記のコメントを全て取得.
     *
     * @param diaryId 日記ID
     * @return コメント情報
     */
    List<FindCommentReplyLinkedUserDto> findCommentsReplies(Integer diaryId);
}
