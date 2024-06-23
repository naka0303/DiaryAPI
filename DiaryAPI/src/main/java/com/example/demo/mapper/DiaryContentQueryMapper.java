package com.example.demo.mapper;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiaryContentQueryMapper {

  /**
   * 日記記事情報取得
   * @param diaryId 日記ID
   * @return 日記記事情報
   */
  public List<FindDiaryContentDto> selectDiaryContentByDiaryId(
          @Param("diaryId") Integer diaryId);
}
