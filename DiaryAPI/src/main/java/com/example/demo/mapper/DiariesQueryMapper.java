package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.diariesContents.entity.DiariesContents;

@Mapper
public interface DiariesQueryMapper {
	
	/**
	 * 日記情報一覧取得
	 * @param userId ユーザーID
	 * @return 日記情報
	 */
	public DiariesContents findDiaryByUserId(Integer userId);
}
