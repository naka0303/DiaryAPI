package com.example.demo.infrastructure.diary.repository;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.domain.diary.entity.Diary;
import com.example.demo.mapper.DiaryQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DairyQueryRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class DiaryQueryRepositoryImpl implements DiaryQueryRepository {

  private final DiaryQueryMapper diaryQueryMapper;

  /**
   * 指定されたユーザーに紐づく日記情報取得.
   *
   * @param userId ユーザーID
   * @return ユーザーに紐づく日記情報
   */
  @Override
  public List<FindDiaryDto> findDiariesByUser(Integer userId) {
    List<FindDiaryDto> dtoList = diaryQueryMapper.selectDiariesByUser(userId);
    if (dtoList == null) {
      return null;
    }

    return new Diary().sort(dtoList);
  }

  /**
   * 指定された日記情報取得.
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   * @return 指定された日記IDの日記情報
   */
  @Override
  public FindDiaryDto findDiaryByUser(Integer userId, Integer diaryId) {
    return diaryQueryMapper.selectDiaryByUser(userId, diaryId);
  }

  /**
   * 全ての日記情報取得
   *
   * @return 日記情報
   */
  @Override
  public List<FindDiaryDto> findDiaries() {
    return diaryQueryMapper.selectDiaries();
  }
}
