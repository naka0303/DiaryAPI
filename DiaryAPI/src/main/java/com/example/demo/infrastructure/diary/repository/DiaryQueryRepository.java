package com.example.demo.infrastructure.diary.repository;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.application.diary.dto.FindDiaryLinkedUserDto;

import java.util.List;

/**
 * DairyQueryRepositoryクラス.
 */
public interface DiaryQueryRepository {

    /**
     * 指定されたユーザーIDに紐づく日記情報取得.
     *
     * @param userId ユーザーID
     * @return ユーザーIDに紐づく日記情報
     */
    List<FindDiaryLinkedUserDto> findDiariesLinkedUser(Integer userId);

    /**
     * 指定された日記IDの日記情報取得.
     *
     * @param diaryId 日記ID
     * @return 指定された日記IDの日記情報
     */
    FindDiaryDto findDiaryById(Integer diaryId);
}
