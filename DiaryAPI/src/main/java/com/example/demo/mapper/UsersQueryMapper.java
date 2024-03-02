package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.users.entity.Users;

@Mapper
public interface UsersQueryMapper {
	
	/**
	 * ユーザー情報一覧取得
	 * @return ユーザー情報
	 */
	public List<Users> findUsers();

	/**
	 * 特定ユーザー情報取得
	 * @param userId
	 * @return 特定ユーザー情報
	 */
	public Users findUserById(Integer userId);
}
