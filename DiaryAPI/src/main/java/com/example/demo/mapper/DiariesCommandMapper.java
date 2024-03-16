package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.infrastructure.diaries.request.RegisterDiaryRequest;

/**
 * DiariesCommandMapperクラス.
 */
@Mapper
public interface DiariesCommandMapper {
  
  /**
   * 日記登録.
   *
   * @param registerDiaryRequest 日記登録情報
   */
  public void insertDiaryByUserId(RegisterDiaryRequest registerDiaryRequest);
  
  /**
   * 日記記事登録.
   *
   * @param registerDiaryRequest 日記登録情報
   */
  public void insertContentByUserId(RegisterDiaryRequest registerDiaryRequest);
}
