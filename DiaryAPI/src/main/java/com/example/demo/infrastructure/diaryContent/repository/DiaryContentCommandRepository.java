package com.example.demo.infrastructure.diaryContent.repository;

import com.example.demo.infrastructure.diaryContent.request.RegisterDiaryContentRequest;

/**
 * DiariesRepositoryクラス.
 */
public interface DiaryContentCommandRepository {

  /**
   * 日記記事登録.
   *
   * @param request 日記記事情報
   */
  public void registerDiaryContentByUserId(RegisterDiaryContentRequest request) throws Exception;
}
