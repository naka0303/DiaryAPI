package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.application.diaries.dto.InsertDiariesDto;

@Mapper
public interface DiariesCommandMapper {
	
	/**
	 * 日記登録
	 * @param insertDiariesDto 日記情報
	 */
	public void insertDiaryByUserId(InsertDiariesDto insertDiariesDto);
	
	/**
	 * 日記記事登録
	 * @param insertDiariesDto 日記情報
	 */
	public void insertContentByUserId(InsertDiariesDto insertDiariesDto);
}
