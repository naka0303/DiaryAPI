package com.example.demo.infrastructure.diaryContent.service;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;
import com.example.demo.infrastructure.diaryContent.repository.DiaryContentQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DiaryContentQueryServiceImplクラス.
 */
@Service
public class DiaryContentQueryServiceImpl implements DiaryContentQueryService {

  private final DiaryContentQueryRepository diaryContentQueryRepository;
  
  public DiaryContentQueryServiceImpl(
          DiaryContentQueryRepository diaryContentQueryRepository) {
      this.diaryContentQueryRepository = diaryContentQueryRepository;
  }

  /**
   * 日記情報一覧取得
   * @param diaryId 日記ID
   * @return 日記記事情報
   */
  @Override
  public List<FindDiaryContentDto> findDiaryContentByDiaryId(Integer diaryId) {
    return this.diaryContentQueryRepository.findDiaryContentByDiaryId(diaryId);
  }
}
