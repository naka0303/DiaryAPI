package com.example.demo.infrastructure.diaries.repository;

import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.infrastructure.diaries.request.RegisterDiaryRequest;

/**
 * DiariesRepositoryクラス.
 */
public interface DiariesRepository {
  
  /**
   * 日記情報一覧取得.
   *
   * @param userId ユーザーID
   *
   * @return 日記情報リスト
   */
  public DiariesContents findDiaryByUserId(Integer userId);

  /**
   * 日記登録.
   *
   * @param registerDiaryRequest 日記情報
   */
  public void registerDiaryByUserId(RegisterDiaryRequest registerDiaryRequest) throws Exception;
}
