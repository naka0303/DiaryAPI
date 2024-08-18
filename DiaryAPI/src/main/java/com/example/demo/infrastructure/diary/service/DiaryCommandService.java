package com.example.demo.infrastructure.diary.service;

import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
import org.springframework.stereotype.Service;

/**
 * DiaryCommandServiceクラス.
 */
@Service
public interface DiaryCommandService {

  /**
   * 日記登録.
   *
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  void registerDiary(RegisterDiaryRequest request) throws Exception;
}
