package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.request.EditUsersRequest;

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
   * @param editUsersRequest 編集ユーザー情報
   */
  public int editUserById(
      @Param("userId") Integer userId,
      @Param("editUsersRequest") EditUsersRequest editUsersRequest);

  /**
   * 特定ユーザー情報削除.
   *
   * @param userId ユーザーID
   */
  public int deleteUserById(@Param("userId") Integer userId);
}
