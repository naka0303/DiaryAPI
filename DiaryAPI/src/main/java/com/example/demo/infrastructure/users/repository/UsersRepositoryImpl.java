package com.example.demo.infrastructure.users.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.advice.NotFoundException;
import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.request.EditUsersRequest;
import com.example.demo.mapper.UsersCommandMapper;
import com.example.demo.mapper.UsersQueryMapper;

import lombok.RequiredArgsConstructor;

/**
 * UsersRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepository {

  private final UsersQueryMapper usersQueryMapper;
	
  private final UsersCommandMapper usersCommandMapper;
	
  /**
   * ユーザー情報一覧取得.
   *
   * @return ユーザー情報
   */
  @Override
  public List<Users> findUsers() {
    return usersQueryMapper.findUsers();
  }
	
  /**
   * 特定ユーザーIDでのユーザー情報取得.
   *
   * @param userId ユーザーID
   * @return 特定ユーザー情報
   */
  @Override
  public Users findUserById(Integer userId) {
    return usersQueryMapper.findUserById(userId);
  }
  
  /**
   * 特定ユーザー名でのユーザー情報取得.
   *
   * @param username ユーザー名
   * @return 特定ユーザー情報
   */
  @Override
  public Users findUserByName(String username) {
    return usersQueryMapper.findUserByName(username);
  }
	
  /**
   * 特定ユーザー情報編集.
   *
   * @param userId ユーザーID
   * @param editUsersRequest 編集ユーザー情報
   */
  @Override
  public void editUserById(Integer userId, EditUsersRequest editUsersRequest) {
    final int cnt = usersCommandMapper.editUserById(userId, editUsersRequest);
    
    if (cnt != 1) {
      throw new NotFoundException(0, "No record edited");
    }
  }

  /**
   * ユーザー登録.
   *
   * @param users 登録ユーザー情報
   */
  @Override
  public void createUser(Users users) {
    final int cnt = usersCommandMapper.createUser(users);
    
    if (cnt != 1) {
      throw new NotFoundException(0, "No record created");
    }
  }

  /**
   * 特定ユーザー情報削除.
   *
   * @param userId ユーザーID
   */
  @Override
  public void deleteUserByUserId(Integer userId) {
    final int cnt = usersCommandMapper.deleteUserById(userId);
    
    if (cnt != 1) {
      throw new NotFoundException(0, "No record deleted");
    }
  }
}
