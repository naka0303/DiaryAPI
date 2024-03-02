package com.example.demo.infrastructure.users.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.advice.NotFoundException;
import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.repository.UsersRepository;
import com.example.demo.infrastructure.users.request.EditUsersRequest;
import com.example.demo.infrastructure.users.request.RegisterUsersRequest;

@Service
@RestControllerAdvice
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

		return users;
	}

	/**
	 *　特定ユーザー情報取得
	 * @param userId ユーザーID
	 * @return 特定ユーザー情報
	 */
	@Override
	public Users findUserById(Integer userId) {
		Users user = usersRepository.findUserById(userId);

		if (user == null) {
			throw new NotFoundException(1, "Not found specified user");
		}

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
		Users user = usersRepository.findUserById(userId);

		if (user == null) {
			throw new NotFoundException(1, "Not found specified user");
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
	
	/**
	 * 特定ユーザー情報削除
	 * @param userId ユーザーID
	 */
	@Override
	public void deleteUserByUserId(Integer userId) {
		usersRepository.deleteUserByUserId(userId);
	}
}
