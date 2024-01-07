package com.example.demo.infrastructure.user.repository;

import java.util.List;

import com.example.demo.application.user.dto.UserDto;
import com.example.demo.domain.user.entity.User;

public interface UserRepository {
	
	/**
	 * ユーザー情報一覧を取得する
	 * @return ユーザー情報
	 */
	public List<UserDto> findAll();

	public void save(User user);

}
