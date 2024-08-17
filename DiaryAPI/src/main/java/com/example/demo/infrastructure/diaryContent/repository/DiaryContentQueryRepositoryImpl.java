package com.example.demo.infrastructure.diaryContent.repository;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;
import com.example.demo.mapper.DiaryContentQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DairyContentQueryRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class DiaryContentQueryRepositoryImpl implements DiaryContentQueryRepository {

  private final DiaryContentQueryMapper diaryContentQueryMapper;

  /**
   * 指定された日記IDに紐づく日記記事
   * @param diaryId   日記ID
   * @return 指定された日記IDに紐づく日記記事
   */
  @Override
  public List<FindDiaryContentDto> findDiaryContentByDiaryId(Integer diaryId) {
    return diaryContentQueryMapper.selectDiaryContentByDiaryId(diaryId);
  }

  /**
   * 指定された日記記事IDに紐づく日記記事
   * @param contentId 日記記事ID
   * @return 指定された日記記事IDに紐づく日記記事
   */
  @Override
  public FindDiaryContentDto findDiaryContentByContentId(Integer contentId) {
    return diaryContentQueryMapper.selectDiaryContentByContentId(contentId);
  }
}
