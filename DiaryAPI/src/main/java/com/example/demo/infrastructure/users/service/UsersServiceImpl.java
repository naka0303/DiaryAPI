package com.example.demo.infrastructure.users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.repository.UsersRepository;
import com.example.demo.infrastructure.users.request.EditUsersRequest;
import com.example.demo.infrastructure.users.request.RegisterUsersRequest;

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
	 *　特定ユーザー情報取得
	 * @param userId ユーザーID
	 * @return 特定ユーザー情報
	 */
	@Override
	public Users findUser(Integer userId) {
		Users user = usersRepository.findUser(userId);
		
		return user;
	};
	
	/**
	 * 特定ユーザー情報編集
	 * @param userId ユーザーID
	 * @param editUsersRequest 編集ユーザー情報
	 */
	@Override
	public void editUserById(Integer userId, EditUsersRequest editUsersRequest) {
		
		// 特定ユーザー情報取得
		Users user = usersRepository.findUser(userId);
		
		if (user == null) {
			// TODO: 例外処理
		}
		
		usersRepository.editUserById(userId, editUsersRequest);
	}

	/**
	 * ユーザー登録
	 * @param registerUsersRequest 登録ユーザー情報
	 */
	@Override
	public void createUser(RegisterUsersRequest registerUsersRequest) {
		usersRepository.createUser(registerUsersRequest);
	}
}
