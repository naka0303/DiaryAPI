package com.example.demo.infrastructure.diary.repository;

import com.example.demo.domain.diary_linked_user.DiaryLinkedUser;
import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
import com.example.demo.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * DiaryCommandRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class DiaryCommandRepositoryImpl implements DiaryCommandRepository {

  private final DiaryCommandMapper diaryCommandMapper;

  /**
   * 日記登録.
   *
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  public void registerDiary(
          RegisterDiaryRequest request) throws Exception {

    DiaryLinkedUser diaryLinkedUser = new DiaryLinkedUser();
    diaryLinkedUser.setUserId(request.getUserId());;

    // 日記とユーザーを紐づける
    final int insertDiaryLinkedUserCnt = diaryCommandMapper.insertDiaryLinkedUser(
        diaryLinkedUser);
    if (insertDiaryLinkedUserCnt != 1) {
      throw new Exception("Insert diaries linked users failed");
    }

    // 登録した日記IDを取得
    Integer diaryId = diaryLinkedUser.getDiaryId();
    if (diaryId == null) {
      throw new Exception("diaryId is null");
    }

    // 日記登録
    final int insertDiaryByUserIdCnt = diaryCommandMapper.insertDiary(
            diaryId, request.getDiaryTitle(), request.getDiaryContent());
    if (insertDiaryByUserIdCnt != 1) {
      throw new Exception("Insert diary failed");
    }
  }
}
