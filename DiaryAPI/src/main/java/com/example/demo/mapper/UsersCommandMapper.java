package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.infrastructure.users.request.EditUsersRequest;
import com.example.demo.infrastructure.users.request.RegisterUsersRequest;

@Mapper
public interface UsersCommandMapper {
	
	/**
	 * ユーザー登録
	 * @param registerUsersRequest 登録ユーザー情報
	 */
	public void createUser(
		@Param("registerUsersRequest") RegisterUsersRequest registerUsersRequest);
	
	/**
	 * 特定ユーザー情報編集
	 * @param userId ユーザーID
	 * @param editUsersRequest 編集ユーザー情報
	 */
	public void editUserById(
		@Param("userId") Integer userId,
		@Param("editUsersRequest") EditUsersRequest editUsersRequest);
}
