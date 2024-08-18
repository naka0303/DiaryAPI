package com.example.demo.mapper;

import com.example.demo.domain.diary_linked_user.DiaryLinkedUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

/**
 * DiaryCommandMapperクラス.
 */
@Mapper
public interface DiaryCommandMapper {
  
  /**
   * 日記紐付け登録.
   *
   * @param userId ユーザーID
   */
  int insertDiaryLinkedUser(
          @Param("diaryLinkedUser") DiaryLinkedUser diaryLinkedUser);

  /**
   * 日記登録.
   *
   * @param diaryId 日記ID
   * @param diaryTitle 日記タイトル
   * @param diaryContent 日記記事内容
   */
  int insertDiary(
          @Param("diaryId") Integer diaryId,
          @Param("diaryTitle") String diaryTitle,
          @Param("diaryContent") String diaryContent);
}