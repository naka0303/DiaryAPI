package com.example.demo.infrastructure.diaryContent.repository;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;

import java.util.List;

/**
 * DairyContentQueryRepositoryクラス.
 */
public interface DiaryContentQueryRepository {

    /**
     * 指定された日記IDに紐づく日記記事
     * @param diaryId 日記ID
     * @return 指定された日記ID/日記記事IDに紐づく日記記事
     */
    List<FindDiaryContentDto> findDiaryContentByDiaryId(Integer diaryId);

  /**
   * 指定された日記記事IDに紐づく日記記事
   * @param contentId 日記記事ID
   * @return 指定された日記記事IDに紐づく日記記事
   */
  FindDiaryContentDto findDiaryContentByContentId(Integer contentId);
}
