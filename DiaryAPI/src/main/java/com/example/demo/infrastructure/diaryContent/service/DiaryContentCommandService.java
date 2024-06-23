package com.example.demo.infrastructure.diaryContent.service;

import com.example.demo.infrastructure.diaryContent.request.RegisterDiaryContentRequest;
import org.springframework.stereotype.Service;

/**
 * DiaryContentCommandServiceクラス.
 */
@Service
public interface DiaryContentCommandService {

  /**
   * 日記記事登録.
   *
   * @param request 日記登録情報
   */
  public void registerDiaryContentByUserId(RegisterDiaryContentRequest request) throws Exception;
}
