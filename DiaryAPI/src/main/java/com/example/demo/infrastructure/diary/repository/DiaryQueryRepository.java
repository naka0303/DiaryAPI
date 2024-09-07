package com.example.demo.infrastructure.diary.repository;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.application.diary.dto.FindDiaryLinkedUserDto;

import java.util.List;

/**
 * DairyQueryRepositoryクラス.
 */
public interface DiaryQueryRepository {

    /**
     * 指定されたユーザーに紐づく日記情報取得.
     *
     * @param userId ユーザーID
     * @return ユーザーに紐づく日記情報
     */
    List<FindDiaryDto> findDiariesByUser(Integer userId);

    /**
     * 指定された日記情報取得.
     *
     * @param userId ユーザーID
     * @param diaryId 日記ID
     * @return 指定された日記IDの日記情報
     */
    FindDiaryDto findDiaryByUser(Integer userId, Integer diaryId);

    /**
     * 全ての日記情報取得
     *
     * @return 日記情報
     */
    List<FindDiaryDto> findDiaries();
}
