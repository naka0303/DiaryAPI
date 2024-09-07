package com.example.demo.infrastructure.exchange.repository;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.domain.diary_linked_user.DiaryLinkedUser;
import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
import com.example.demo.infrastructure.diary.request.UpdateDiaryRequest;
import com.example.demo.infrastructure.exchange.request.RegisterCommentRequest;
import com.example.demo.mapper.DiaryCommandMapper;
import com.example.demo.mapper.DiaryQueryMapper;
import com.example.demo.mapper.ExchangeCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * DiaryCommandRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class ExchangeCommandRepositoryImpl implements ExchangeCommandRepository {

  private final ExchangeCommandMapper exchangeCommandMapper;

  /**
   * コメント投稿.
   *
   * @param diaryId 日記ID
   * @param request コメント登録内容
   * @throws Exception 例外処理
   */
  @Override
  public void registerComment(
      Integer diaryId, RegisterCommentRequest request) throws Exception {
    final int cnt = exchangeCommandMapper.insertComment(
        diaryId, request.getUserId(), request.getComment());
    if (cnt != 1) {
      throw new Exception("Register comment failed");
    }
  }
}
