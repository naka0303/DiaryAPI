package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.application.users.dto.InsertUsersDto;

@Mapper
public interface UsersCommandMapper {
	
	/**
	 * 新規ユーザー登録
	 * @param insertUsersDto ユーザー情報
	 */
	public void createUser(InsertUsersDto insertUsersDto);
}
