package com.example.demo.infrastructure.diary.repository;

import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;

/**
 * DiaryCommandRepositoryクラス.
 */
public interface DiaryCommandRepository {

  /**
   * 日記登録.
   *
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  void registerDiary(RegisterDiaryRequest request) throws Exception;
}
