package com.example.demo.infrastructure.users.repository;

import java.util.List;

import com.example.demo.application.users.dto.InsertUsersDto;
import com.example.demo.domain.users.entity.Users;

public interface UsersRepository {
	
	/**
	 * ユーザー情報一覧取得
	 * @return ユーザー情報リスト
	 */
	public List<Users> findUsers();

	/**
	 * 新規ユーザー登録
	 * @param insertUsersDto ユーザー情報
	 */
	public void createUser(InsertUsersDto insertUsersDto);

}
