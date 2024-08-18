package com.example.demo.infrastructure.diary.service;

import com.example.demo.infrastructure.diary.repository.DiaryCommandRepository;
import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
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
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  @Override
  public void registerDiary(RegisterDiaryRequest request) throws Exception {
    diaryCommandRepository.registerDiary(request);
  }
}
