package com.example.demo.infrastructure.users.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.request.EditUsersRequest;
import com.example.demo.infrastructure.users.request.RegisterUsersRequest;
import com.example.demo.mapper.UsersCommandMapper;
import com.example.demo.mapper.UsersQueryMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepository {
	
	private final UsersQueryMapper usersQueryMapper;
	
	private final UsersCommandMapper usersCommandMapper;
	
	/**
	 * ユーザー情報一覧取得
	 * @return ユーザー情報
	 */
	@Override
	public List<Users> findUsers() {
		return usersQueryMapper.findUsers();
	}
	
	/**
	 * 特定ユーザー情報取得
	 * @param userId ユーザーID
	 * @return 特定ユーザー情報
	 */
	@Override
	public Users findUser(Integer userId) {
		return usersQueryMapper.findUser(userId);
	}
	
	/**
	 * 特定ユーザー情報編集
	 * @param userId ユーザーID
	 * @param editUsersRequest 編集ユーザー情報
	 */
	@Override
	public void editUserById(Integer userId, EditUsersRequest editUsersRequest) {
		usersCommandMapper.editUserById(userId, editUsersRequest);
	}

	/**
	 * ユーザー登録
	 * @param registerUsersRequest 登録ユーザー情報
	 */
	@Override
	public void createUser(RegisterUsersRequest registerUsersRequest) {
		usersCommandMapper.createUser(registerUsersRequest);
	}
}
