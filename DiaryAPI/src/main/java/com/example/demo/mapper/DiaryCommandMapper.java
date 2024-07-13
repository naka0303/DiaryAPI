package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

/**
 * DiariesCommandMapperクラス.
 */
@Mapper
public interface DiaryCommandMapper {
  
  /**
   * 日記紐付け登録.
   *
   * @param userId ユーザーID
   */
  int insertDiaryByUserId(
          @Param("userId") Integer userId);
}