package com.example.demo.infrastructure.user.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.application.user.dto.UserDto;
import com.example.demo.domain.user.entity.User;
import com.example.demo.mapper.UserQueryMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
	
	private final UserQueryMapper userQueryMapper;
	
	/**
	 * ユーザー情報一覧を取得する
	 * @return ユーザー情報
	 */
	public List<UserDto> findAll() {
		return userQueryMapper.findAll();
	}

	@Override
	public void save(User user) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
