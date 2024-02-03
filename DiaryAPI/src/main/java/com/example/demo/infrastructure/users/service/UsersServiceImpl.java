package com.example.demo.infrastructure.users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.application.users.dto.InsertUsersDto;
import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	private final UsersRepository usersRepository;
	
	public UsersServiceImpl(
			UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	/**
	 * ユーザー情報一覧取得
	 * @return ユーザー情報リスト
	 */
	@Override
	public List<Users> findUsers() {
		List<Users> users = usersRepository.findUsers();
		
		// TODO: nullチェック
		
		return users;
	}

	/**
	 * 新規ユーザー登録
	 * @param insertUsersDto ユーザー情報
	 */
	@Override
	public void createUser(InsertUsersDto insertUsersDto) {		
		usersRepository.createUser(insertUsersDto);
	};
}
