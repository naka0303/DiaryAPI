package com.example.demo.infrastructure.diaries.service;

import com.example.demo.infrastructure.diaries.request.RegisterDiaryRequest;
import org.springframework.stereotype.Service;

import com.example.demo.domain.diariesContents.entity.DiariesContents;

/**
 * DiariesServiceクラス.
 */
@Service
public interface DiariesService {
	
  /**
   * 日記情報一覧取得.
   *
   * @param userId ユーザーID
   *
   * @return 日記情報
   */
  public DiariesContents findDiaryByUserId(Integer userId);

  /**
   * 日記登録.
   *
   * @param registerDiaryRequest 日記登録情報
   */
  public void registerDiaryByUserId(RegisterDiaryRequest registerDiaryRequest) throws Exception;
}
