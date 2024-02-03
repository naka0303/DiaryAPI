package com.example.demo.infrastructure.users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.application.users.dto.InsertUsersDto;
import com.example.demo.domain.users.entity.Users;

@Service
public interface UsersService {
	
	/**
	 * ユーザー情報一覧取得
	 * @return 
	 * @return ユーザー情報
	 */
	public List<Users> findUsers();

	/**
	 * ユーザー新規登録
	 * @param insertUsersDto ユーザー情報
	 */
	public void createUser(InsertUsersDto insertUsersDto);
}
