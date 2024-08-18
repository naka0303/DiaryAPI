package com.example.demo.infrastructure.diary.repository;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.application.diary.dto.FindDiaryLinkedUserDto;
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
   * 指定されたユーザーIDに紐づく日記情報取得.
   *
   * @param userId ユーザーID
   * @return ユーザーIDに紐づく日記情報
   */
  @Override
  public List<FindDiaryLinkedUserDto> findDiariesLinkedUser(Integer userId) {
    return diaryQueryMapper.selectDiariesLinkedUser(userId);
  }

  /**
   * 指定された日記IDの日記情報取得.
   *
   * @param diaryId 日記ID
   * @return 指定された日記IDの日記情報
   */
  @Override
  public FindDiaryDto findDiaryById(Integer diaryId) {
    return diaryQueryMapper.selectDiaryById(diaryId);
  }
}
