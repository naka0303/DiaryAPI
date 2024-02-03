package com.example.demo.infrastructure.users.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.application.users.dto.InsertUsersDto;
import com.example.demo.domain.users.entity.Users;
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
	public List<Users> findUsers() {
		return usersQueryMapper.findUsers();
	}

	/**
	 * 新規ユーザー登録
	 * @param insertUsersDto ユーザー情報
	 */
	public void createUser(InsertUsersDto insertUsersDto) {
		usersCommandMapper.createUser(insertUsersDto);
	}
}
