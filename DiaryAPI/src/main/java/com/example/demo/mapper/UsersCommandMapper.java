package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.users.entity.Users;

/**
 * UsersCommandMapperクラス.
 */
@Mapper
public interface UsersCommandMapper {
  
  /**
   * ユーザー登録.
   *
   * @param users 登録ユーザー情報
   */
  public int createUser(@Param("users") Users users);
  
  /**
   * 特定ユーザー情報編集.
   *
   * @param userId ユーザーID
   * @param username ユーザー名
   * @param age 年齢
   * @param email メールアドレス
   * @param auth 権限
   * @param diaryId 日記ID
   */
  public int editUserById(
      @Param("userId") Integer userId,
      @Param("username") String username,
      @Param("age") Integer age,
      @Param("email") String email,
      @Param("auth") String auth,
      @Param("diaryId") Integer diaryId);

  /**
   * 日記ID編集
   * @param userId ユーザーID
   * @param diaryId 日記ID
   */
  public int editDiaryIdById(
      @Param("userId") Integer userId,
      @Param("diaryId") Integer diaryId);

  /**
   * 特定ユーザー情報削除.
   *
   * @param userId ユーザーID
   */
  public int deleteUserById(@Param("userId") Integer userId);
}
