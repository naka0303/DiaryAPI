package com.example.demo.infrastructure.diary.service;

import com.example.demo.infrastructure.diary.repository.DiaryCommandRepository;
import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
import com.example.demo.infrastructure.diary.request.UpdateDiaryRequest;
import org.springframework.stereotype.Service;

/**
 * DiaryCommandServiceImplクラス.
 */
@Service
public class DiaryCommandServiceImpl implements DiaryCommandService {
  
  private final DiaryCommandRepository diaryCommandRepository;
  
  public DiaryCommandServiceImpl(
          DiaryCommandRepository diaryCommandRepository) {
    this.diaryCommandRepository = diaryCommandRepository;
  }

  /**
   * 日記登録.
   *
   * @param userId ユーザーID
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  @Override
  public void registerDiary(Integer userId, RegisterDiaryRequest request) throws Exception {
    diaryCommandRepository.registerDiary(userId, request);
  }

  /**
   * 日記更新.
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  @Override
  public void updateDiary(Integer userId, Integer diaryId, UpdateDiaryRequest request) throws Exception {
    diaryCommandRepository.updateDiary(userId, diaryId, request);
  }
}
