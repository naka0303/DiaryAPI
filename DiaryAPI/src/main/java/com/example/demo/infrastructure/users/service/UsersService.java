package com.example.demo.infrastructure.users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.request.EditUsersRequest;
import com.example.demo.infrastructure.users.request.RegisterUsersRequest;

/**
 * UsersServiceクラス.
 */
@Service
public interface UsersService {
	
  /**
   * ユーザー情報一覧取得.
   *
   * @return ユーザー情報
   */
  public List<Users> findUsers();

  /**
   * 特定ユーザー情報取得.
   *
   * @param userId
   * 
   * @return ユーザー情報
   */
  public Users findUserById(Integer userId);
	
  /**
   * 特定ユーザー情報編集.
   *
   * @param userId ユーザーID
   * @param editUsersRequest 編集ユーザー情報
   */
  public void editUserById(Integer userId, EditUsersRequest editUsersRequest);
	
  /**
   * ユーザー新規登録.
   *
   * @param registerUsersRequest 登録ユーザー情報
   */
  public void createUser(RegisterUsersRequest registerUsersRequest);

  /**
   * 特定ユーザー情報削除.
   *
   * @param userId ユーザーID
   */
  public void deleteUserByUserId(Integer userId);
}
