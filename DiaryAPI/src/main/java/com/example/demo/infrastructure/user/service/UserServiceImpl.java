package com.example.demo.infrastructure.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.user.entity.User;
import com.example.demo.infrastructure.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(
			UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	/**
	 * ユーザー情報一覧を取得する
	 * @return ユーザー情報
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * ユーザー新規登録
	 * @param ユーザー情報
	 * @return 
	 */
	@Override
	public void createUser(User user) {
		userRepository.save(user);
	};
}
