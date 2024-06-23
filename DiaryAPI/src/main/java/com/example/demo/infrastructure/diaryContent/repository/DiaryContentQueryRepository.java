package com.example.demo.infrastructure.diaryContent.repository;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;

import java.util.List;

/**
 * DairyContentQueryRepositoryクラス.
 */
public interface DiaryContentQueryRepository {

    /**
     * 日記記事情報取得
     * @param diaryId 日記ID
     */
    public List<FindDiaryContentDto> findDiaryContentByDiaryId(Integer diaryId);
}
