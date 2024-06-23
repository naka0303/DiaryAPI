package com.example.demo.infrastructure.users.repository;

import java.util.List;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.request.EditUsersRequest;

/**
 * UsersRepositoryクラス.
 */
public interface UsersRepository {

  /**
   * ユーザー情報一覧取得.
   *
   * @return ユーザー情報リスト
   */
  public List<Users> findUsers();

  /**
   * 特定ユーザーIDでのユーザー情報取得.
   *
   * @param userId ユーザーID
   *
   * @return 特定ユーザー情報
   */
  public Users findUserById(Integer userId);
  
  /**
   * 特定ユーザー名でのユーザー情報取得.
   *
   * @param username ユーザー名
   *
   * @return 特定ユーザー情報
   */
  public Users findUserByName(String username);
	
  /**
   * 特定ユーザー情報編集.
   *
   * @param userId ユーザーID
   * @param editUsersRequest 編集ユーザー情報
   * 
   * @throws Exception 例外
   */
  public void editUserById(Integer userId, EditUsersRequest editUsersRequest);
	
  /**
   * ユーザー登録.
   *
   * @param users 登録ユーザー情報
   */
  public void createUser(Users users);
  
  /**
   * 特定ユーザー情報削除.
   *
   * @param userId ユーザーID
   */
  public void deleteUserByUserId(Integer userId);
}
