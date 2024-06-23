package com.example.demo.infrastructure.contents.service;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DiaryContentQueryServiceクラス.
 */
@Service
public interface DiaryContentQueryService {
	
  /**
   * 日記記事情報取得.
   *
   * @param diaryId 日記ID
   *
   * @return 日記記事情報
   */
  public List<FindDiaryContentDto> findDiaryContentByDiaryId(Integer diaryId);
}
