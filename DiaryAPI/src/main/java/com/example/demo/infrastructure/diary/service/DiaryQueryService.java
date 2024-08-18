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
   * 指定されたユーザーIDに紐づく日記情報取得.
   *
   * @param userId ユーザーID
   * @return ユーザーIDに紐づく日記情報
   */
  List<FindDiaryDto> findDiariesByUserId(Integer userId);

  /**
   * 指定された日記IDの日記記事情報取得.
   *
   * @param diaryId 日記ID
   * @return 指定された日記IDの日記情報
   */
  FindDiaryDto findDiaryById(Integer diaryId);
}