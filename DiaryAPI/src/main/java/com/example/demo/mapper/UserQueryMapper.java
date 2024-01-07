package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.user.entity.User;

@Mapper
public interface UserQueryMapper {
	
	/**
	 * ユーザー情報一覧を取得する
	 * @return ユーザー情報
	 */
	public List<User> findAll();
}
