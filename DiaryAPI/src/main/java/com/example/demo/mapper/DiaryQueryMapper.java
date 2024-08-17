package com.example.demo.mapper;

import com.example.demo.application.diary.dto.FindDiaryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiaryQueryMapper {

  /**
   * 指定されたユーザーIDに紐づく日記情報取得
   * @param userId ユーザーID
   * @return 指定されたユーザーIDに紐づく日記情報
   */
  FindDiaryDto selectDiaryByUserId(Integer userId);
}
