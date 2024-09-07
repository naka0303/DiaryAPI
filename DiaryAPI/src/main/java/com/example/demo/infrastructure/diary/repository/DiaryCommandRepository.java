package com.example.demo.infrastructure.diary.repository;

import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
import com.example.demo.infrastructure.diary.request.UpdateDiaryRequest;
import jakarta.persistence.criteria.CriteriaBuilder;

/**
 * DiaryCommandRepositoryクラス.
 */
public interface DiaryCommandRepository {

  /**
   * 日記登録.
   *
   * @param userId ユーザーID
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  void registerDiary(
      Integer userId, RegisterDiaryRequest request) throws Exception;

  /**
   * 日記更新.
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  void updateDiary(
      Integer userId, Integer diaryId, UpdateDiaryRequest request) throws Exception;

  /**
   * 日記削除.
   *
   * @param userId ユーザーID
   * @param diaryId 注文ID
   * @throws Exception 例外処理
   */
  void deleteDiary(Integer userId, Integer diaryId) throws Exception;
}
