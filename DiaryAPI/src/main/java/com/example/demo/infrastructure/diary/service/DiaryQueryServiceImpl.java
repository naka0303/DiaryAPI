package com.example.demo.infrastructure.diary.service;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.infrastructure.diary.repository.DiaryQueryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * DiaryQueryServiceImplクラス.
 */
@Service
public class DiaryQueryServiceImpl implements DiaryQueryService {

  private final DiaryQueryRepository diaryQueryRepository;
  
  public DiaryQueryServiceImpl(
          DiaryQueryRepository diaryQueryRepository) {
      this.diaryQueryRepository = diaryQueryRepository;
  }

  /**
   * 指定されたユーザーに紐づく日記情報取得.
   *
   * @param userId ユーザーID
   * @return ユーザーに紐づく日記情報
   */
  @Override
  public List<FindDiaryDto> findDiariesByUser(Integer userId) throws Exception {
    if (userId == null) {
      throw new Exception("userId is null");
    }
    return diaryQueryRepository.findDiariesByUser(userId);
  }

  /**
   * 指定された日記情報取得.
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   * @return 指定された日記情報
   */
  @Override
  public FindDiaryDto findDiaryByUser(Integer userId, Integer diaryId) {
    return diaryQueryRepository.findDiaryByUser(userId, diaryId);
  }

  /**
   * 全ての日記情報取得.
   *
   * @return 日記情報
   */
  @Override
  public List<FindDiaryDto> findDiaries() {
    return diaryQueryRepository.findDiaries();
  }
}
