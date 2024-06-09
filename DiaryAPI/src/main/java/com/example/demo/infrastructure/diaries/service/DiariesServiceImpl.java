package com.example.demo.infrastructure.diaries.service;


import com.example.demo.infrastructure.diaries.request.RegisterDiaryRequest;
import org.springframework.stereotype.Service;

import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.infrastructure.diaries.repository.DiariesRepository;

/**
 * DiariesServiceImplクラス.
 */
@Service
public class DiariesServiceImpl implements DiariesService {
  
  private final DiariesRepository diariesRepository;
  
  public DiariesServiceImpl(
      DiariesRepository diariesRepository) {
    this.diariesRepository = diariesRepository;
  }
  
  /**
   * 日記情報一覧取得
   * @param userId ユーザーID
   * @return 日記情報リスト
   */
  @Override
  public DiariesContents findDiaryByUserId(Integer userId) {
    DiariesContents diariesContents = diariesRepository.findDiaryByUserId(userId);
    
    // TODO: nullチェック
    
    return diariesContents;
  }

  /**
   * 日記登録.
   * @param registerDiaryRequest 日記登録情報
   */
  @Override
  public void registerDiaryByUserId(RegisterDiaryRequest registerDiaryRequest) throws Exception {
    diariesRepository.registerDiaryByUserId(registerDiaryRequest);
  }
}
