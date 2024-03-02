package com.example.demo.infrastructure.users.repository;

import java.util.List;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.request.EditUsersRequest;
import com.example.demo.infrastructure.users.request.RegisterUsersRequest;

public interface UsersRepository {
	
	/**
	 * ユーザー情報一覧取得
	 * @return ユーザー情報リスト
	 */
	public List<Users> findUsers();

	/**
	 * 特定ユーザー情報取得
	 * @param userId ユーザーIDß
	 * @return 特定ユーザー情報
	 */
	public Users findUserById(Integer userId);
	
	/**
	 * 特定ユーザー情報編集
	 * @param userId ユーザーID
	 * @param editUsersRequest 編集ユーザー情報
	 * @throws Exception 
	 */
	public void editUserById(Integer userId, EditUsersRequest editUsersRequest);
	
	/**
	 * ユーザー登録
	 * @param registerUsersRequest 登録ユーザー情報
	 */
	public void createUser(RegisterUsersRequest registerUsersRequest);

	/**
	 * 特定ユーザー情報削除
	 * @param userId
	 */
	public void deleteUserByUserId(Integer userId);
}
