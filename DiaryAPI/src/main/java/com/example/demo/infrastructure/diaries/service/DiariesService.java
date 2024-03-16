package com.example.demo.infrastructure.diaries.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.infrastructure.diaries.request.RegisterDiaryRequest;

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
  public List<DiariesContents> findDiariesByUserId(Integer userId);

  /**
   * 日記登録.
   *
   * @param registerDiaryRequest 日記登録情報
   */
  public void createDiaryByUserId(RegisterDiaryRequest registerDiaryRequest);
}
