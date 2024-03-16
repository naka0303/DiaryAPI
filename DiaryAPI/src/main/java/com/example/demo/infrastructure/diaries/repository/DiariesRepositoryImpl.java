package com.example.demo.infrastructure.diaries.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.infrastructure.diaries.request.RegisterDiaryRequest;
import com.example.demo.mapper.DiariesCommandMapper;
import com.example.demo.mapper.DiariesQueryMapper;

import lombok.RequiredArgsConstructor;

/**
 * DiariesRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class DiariesRepositoryImpl implements DiariesRepository {
  
  private final DiariesQueryMapper diariesQueryMapper;
  
  private final DiariesCommandMapper diariesCommandMapper;
  
  /**
   * 日記情報一覧取得.
   *
   * @return 日記情報
   */
  public List<DiariesContents> findDiariesByUserId(Integer userId) {
    return diariesQueryMapper.findDiariesByUserId(userId);
  }

  /**
   * 日記登録.
   *
   * @param registerDiaryRequest 日記登録情報
   */
  public void createDiaryByUserId(
      RegisterDiaryRequest registerDiaryRequest) {
    
    // ブログが初投稿であれば、diariesテーブルに紐付け情報を登録する
    List<DiariesContents> diaryByUserId =
        diariesQueryMapper.findDiariesByUserId(registerDiaryRequest.getUserId());
    if (diaryByUserId.size() == 0)  {
      diariesCommandMapper.insertDiaryByUserId(registerDiaryRequest);
    }
    diariesCommandMapper.insertContentByUserId(registerDiaryRequest);
  }
}
