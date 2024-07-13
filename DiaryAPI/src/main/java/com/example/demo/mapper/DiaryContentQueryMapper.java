package com.example.demo.mapper;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiaryContentQueryMapper {

  /**
   * 指定された日記IDに紐づく日記記事取得
   * @param diaryId 日記ID
   * @return 指定された日記IDに紐づく日記記事
   */
   List<FindDiaryContentDto> selectDiaryContentByDiaryId(
          @Param("diaryId") Integer diaryId);

  /**
   * 指定された日記記事IDに紐づく日記記事取得
   * @param contentId 日記記事ID
   * @return 指定された日記記事IDに紐づく日記記事
   */
  FindDiaryContentDto selectDiaryContentByContentId(
          @Param("contentId") Integer contentId);
}
