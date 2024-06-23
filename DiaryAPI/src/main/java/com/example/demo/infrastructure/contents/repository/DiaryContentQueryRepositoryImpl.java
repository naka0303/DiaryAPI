package com.example.demo.infrastructure.contents.repository;

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

  @Override
  public List<FindDiaryContentDto> findDiaryContentByDiaryId(Integer diaryId) {
    return diaryContentQueryMapper.selectDiaryContentByDiaryId(diaryId);
  }
}
