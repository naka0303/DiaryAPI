package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

public interface DiaryContentCommandMapper {

  /**
   * 日記記事登録.
   *
   * @param diaryId 日記ID
   * @param diaryTitle 日記タイトル
   * @param diaryContent 日記記事内容
   */
  public int insertDiaryContentByUserId(
          @Param("diaryId") Integer diaryId,
          @Param("diaryTitle") String diaryTitle,
          @Param("diaryContent") String diaryContent);
}
