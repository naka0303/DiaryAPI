package com.example.demo.infrastructure.diaryContent.service;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DiaryContentQueryServiceクラス.
 */
@Service
public interface DiaryContentQueryService {
	
  /**
   * 指定された日記IDに紐づく日記記事取得.
   * @param diaryId 日記ID
   * @return 指定された日記IDに紐づく日記記事
   */
  List<FindDiaryContentDto> findDiaryContentByDiaryId(Integer diaryId);

  /**
   * 指定された日記記事IDに紐づく日記記事取得.
   * @param contentId 日記記事ID
   * @return 指定された日記記事IDに紐づく日記記事
   */
  FindDiaryContentDto findDiaryContentByContentId(
          Integer contentId);
}
