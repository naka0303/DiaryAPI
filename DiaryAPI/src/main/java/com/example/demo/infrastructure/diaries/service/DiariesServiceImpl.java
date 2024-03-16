package com.example.demo.infrastructure.diaries.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.infrastructure.diaries.repository.DiariesRepository;
import com.example.demo.infrastructure.diaries.request.RegisterDiaryRequest;

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
  public List<DiariesContents> findDiariesByUserId(Integer userId) {
    List<DiariesContents> diariesContents = diariesRepository.findDiariesByUserId(userId);
    
    // TODO: nullチェック
    
    return diariesContents;
  }

  /**
   * 日記登録.
   * @param registerDiaryRequest 日記登録情報
   */
  @Override
  public void createDiaryByUserId(RegisterDiaryRequest registerDiaryRequest) {
    diariesRepository.createDiaryByUserId(registerDiaryRequest);
  }
}
