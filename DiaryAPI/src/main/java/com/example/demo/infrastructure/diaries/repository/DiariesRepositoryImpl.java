package com.example.demo.infrastructure.diaries.repository;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.diaries.request.RegisterDiaryRequest;
import com.example.demo.mapper.UsersCommandMapper;
import com.example.demo.mapper.UsersQueryMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.mapper.DiariesCommandMapper;
import com.example.demo.mapper.DiariesQueryMapper;

import lombok.RequiredArgsConstructor;

/**
 * DiariesRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class DiariesRepositoryImpl implements DiariesRepository {
  
  private final DiariesQueryMapper diariesQueryMapper;
  
  private final DiariesCommandMapper diariesCommandMapper;

  private final UsersQueryMapper usersQueryMapper;

  private final UsersCommandMapper usersCommandMapper;
  
  /**
   * 日記情報一覧取得.
   *
   * @return 日記情報
   */
  public DiariesContents findDiaryByUserId(Integer userId) {
    return diariesQueryMapper.findDiaryByUserId(userId);
  }

  /**
   * 日記登録.
   *
   * @param request 日記登録情報
   */
  public void registerDiaryByUserId(
          RegisterDiaryRequest request) throws Exception {
    
    // ブログが初投稿であれば、diariesテーブルに紐付け情報を登録する
    Users user = usersQueryMapper.findUserById(request.getUserId());
    if (user == null) {
      throw new Exception("User not found");
    }

    if (user.getDiaryId() == null)  {
      // diariesテーブルにユーザーとの紐付け情報を登録
      final int insertCnt = diariesCommandMapper.insertDiaryByUserId(
              request.getUserId());
      if (insertCnt != 1) {
        throw new Exception("Insert diary failed");
      }

      // diariesテーブルからdiaryIdを取得
      DiariesContents diaryByUserId =
              diariesQueryMapper.findDiaryByUserId(request.getUserId());
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
    final int insertCnt = diariesCommandMapper.insertContentByUserId(
            user.getDiaryId(), request.getDiaryTitle(), request.getDiaryContent());
    if (insertCnt != 1) {
      throw new Exception("Insert content failed");
    }
  }
}
