package com.example.demo.infrastructure.diaries.repository;

import java.util.List;

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
  public List<DiariesContents> findDiariesByUserId(Integer userId);

  /**
   * 日記登録.
   *
   * @param registerDiaryRequest 日記情報
   */
  public void createDiaryByUserId(RegisterDiaryRequest registerDiaryRequest);
}
