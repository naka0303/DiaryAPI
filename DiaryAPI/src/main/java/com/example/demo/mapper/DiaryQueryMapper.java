package com.example.demo.mapper;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.application.diary.dto.FindDiaryLinkedUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiaryQueryMapper {

  /**
   * 指定されたユーザーに紐づく日記情報取得.
   *
   * @param userId ユーザーID
   * @return ユーザーに紐づく日記情報
   */
  List<FindDiaryDto> selectDiariesByUser(
      @Param("userId") Integer userId);

  /**
   * 指定された日記情報取得.
   *
   * @param diaryId 日記ID
   * @return 指定された日記情報
   */
  FindDiaryDto selectDiaryByUser(
      @Param("userId") Integer userId,
      @Param("diaryId") Integer diaryId);
}
