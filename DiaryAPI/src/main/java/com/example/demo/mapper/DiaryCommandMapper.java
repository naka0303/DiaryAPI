package com.example.demo.mapper;

import com.example.demo.domain.diary_linked_user.DiaryLinkedUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * DiaryCommandMapperクラス.
 */
@Mapper
public interface DiaryCommandMapper {
  
  /**
   * 日記紐付け登録.
   *
   * @param diaryLinkedUser 紐づけ情報
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

  /**
   * 日記更新.
   *
   * @param diaryId 日記IUD
   * @param diaryTitle 日記タイトル
   * @param diaryContent 日記内容
   */
  int updateDiary(
      @Param("diaryId") Integer diaryId,
      @Param("diaryTitle") String diaryTitle,
      @Param("diaryContent") String diaryContent);

  /**
   * 日記削除.
   *
   * @param diaryId 日記ID
   */
  int deleteDiary(
      @Param("diaryId") Integer diaryId);

  /**
   * 日記とユーザーの紐づきを削除
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   */
  int deleteDiaryLinkedUser(
      @Param("userId") Integer userId,
      @Param("diaryId") Integer diaryId);
}