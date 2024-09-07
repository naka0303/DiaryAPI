package com.example.demo.infrastructure.diary.service;

import com.example.demo.application.diary.dto.FindDiaryDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DiaryQueryServiceクラス.
 */
@Service
public interface DiaryQueryService {

  /**
   * 指定されたユーザーに紐づく日記情報取得.
   *
   * @param userId ユーザーID
   * @return ユーザーIDに紐づく日記情報
   */
  List<FindDiaryDto> findDiariesByUser(Integer userId) throws Exception;

  /**
   * 指定された日記情報取得.
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   * @return 指定された日記情報
   */
  FindDiaryDto findDiaryByUser(Integer userId, Integer diaryId);

  /**
   * 全ての日記情報取得.
   *
   * @return 日記情報
   */
  List<FindDiaryDto> findDiaries();
}
