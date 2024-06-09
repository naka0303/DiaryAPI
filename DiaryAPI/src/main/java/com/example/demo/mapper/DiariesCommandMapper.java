package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

/**
 * DiariesCommandMapperクラス.
 */
@Mapper
public interface DiariesCommandMapper {
  
  /**
   * 日記登録.
   *
   * @param userId ユーザーID
   */
  public int insertDiaryByUserId(
          @Param("userId") Integer userId);
  
  /**
   * 日記記事登録.
   *
   * @param diaryId 日記ID
   * @param diaryTitle 日記タイトル
   * @param diaryContent 日記記事内容
   */
  public int insertContentByUserId(
          @Param("diaryId") Integer diaryId,
          @Param("diaryTitle") String diaryTitle,
          @Param("diaryContent") String diaryContent);
}