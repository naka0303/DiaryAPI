package com.example.demo.infrastructure.diaryContent.repository;

import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.diaryContent.request.RegisterDiaryContentRequest;
import com.example.demo.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * DiaryContentCommandRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class DiaryContentCommandRepositoryImpl implements DiaryContentCommandRepository {
  
  private final DiaryQueryMapper diaryQueryMapper;
  
  private final DiaryCommandMapper diaryCommandMapper;

  private final DiaryContentCommandMapper diaryContentCommandMapper;

  private final UsersQueryMapper usersQueryMapper;

  private final UsersCommandMapper usersCommandMapper;

  /**
   * 日記記事登録.
   *
   * @param request 日記登録情報
   */
  public void registerDiaryContentByUserId(
          RegisterDiaryContentRequest request) throws Exception {
    
    // ブログが初投稿であれば、diariesテーブルに紐付け情報を登録する
    Users user = usersQueryMapper.findUserById(request.getUserId());
    if (user == null) {
      throw new Exception("User not found");
    }

    if (user.getDiaryId() == null)  {
      // diariesテーブルにユーザーとの紐付け情報を登録
      final int insertCnt = diaryCommandMapper.insertDiaryByUserId(
              request.getUserId());
      if (insertCnt != 1) {
        throw new Exception("Insert diary failed");
      }

      // diariesテーブルからdiaryIdを取得
      DiariesContents diaryByUserId =
              diaryQueryMapper.findDiaryByUserId(request.getUserId());
      if (diaryByUserId == null) {
        throw new Exception("Diary not found");
      }

      // ユーザー情報編集
      final int editCnt = usersCommandMapper.editDiaryIdById(
              request.getUserId(), diaryByUserId.getDiaryId());
      if (editCnt != 1) {
        throw new Exception("Edit diaryId failed");
      }
    }

    // ユーザーIDでのユーザー情報取得
    user = usersQueryMapper.findUserById(request.getUserId());
    if (user == null) {
      throw new Exception("User not found");
    }

    // 日記記事登録
    final int insertCnt = diaryContentCommandMapper.insertDiaryContentByUserId(
            user.getDiaryId(), request.getDiaryTitle(), request.getDiaryContent());
    if (insertCnt != 1) {
      throw new Exception("Insert content failed");
    }
  }
}
