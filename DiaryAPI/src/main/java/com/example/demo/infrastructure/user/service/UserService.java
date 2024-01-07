package com.example.demo.infrastructure.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.user.entity.User;

@Service
public interface UserService {
	
	/**
	 * ユーザー情報一覧取得
	 * @return ユーザー情報
	 */
	public List<User> findAll();

	/**
	 * ユーザー新規登録
	 * @param user ユーザー情報
	 * @return 
	 */
	public void createUser(User user);
}
