package com.example.demo.infrastructure.diary.repository;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.domain.diary_linked_user.DiaryLinkedUser;
import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
import com.example.demo.infrastructure.diary.request.UpdateDiaryRequest;
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

  private final DiaryQueryMapper diaryQueryMapper;

  /**
   * 日記登録.
   *
   * @param userId ユーザーID
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  public void registerDiary(
      Integer userId, RegisterDiaryRequest request) throws Exception {

    DiaryLinkedUser diaryLinkedUser = new DiaryLinkedUser();
    diaryLinkedUser.setUserId(userId);

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

  /**
   * 日記更新.
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  @Override
  public void updateDiary(
      Integer userId, Integer diaryId, UpdateDiaryRequest request) throws Exception {

    // 指定された日記の存在確認
    FindDiaryDto diaryDto = diaryQueryMapper.selectDiaryByUser(userId, diaryId);
    if (diaryDto == null) {
      throw new Exception("Specified diary not found");
    }

    // 日記更新
    final int updateCnt = diaryCommandMapper.updateDiary(
        diaryId, request.getDiaryTitle(), request.getDiaryContent());
    if (updateCnt != 1) {
      throw new Exception("Update diary failed");
    }
  }

  /**
   * 日記削除.
   *
   * @param userId  ユーザーID
   * @param diaryId 注文ID
   */
  @Override
  public void deleteDiary(Integer userId, Integer diaryId) throws Exception {
    final int deleteDiaryCnt = diaryCommandMapper.deleteDiary(diaryId);
    if (deleteDiaryCnt != 1) {
      throw new Exception("Delete diary failed");
    }

    final int deleteDiaryLinkedUserCnt =
        diaryCommandMapper.deleteDiaryLinkedUser(userId, diaryId);
    if (deleteDiaryLinkedUserCnt != 1) {
      throw new Exception("Delete diary linked user failed");
    }
  }
}
