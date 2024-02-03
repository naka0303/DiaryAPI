package com.example.demo.infrastructure.diaries.repository;

import java.util.List;

import com.example.demo.application.diaries.dto.InsertDiariesDto;
import com.example.demo.domain.diariesContents.entity.DiariesContents;

public interface DiariesRepository {
	
	/**
	 * 日記情報一覧取得
	 * @param ユーザーID
	 * @return 日記情報リスト
	 */
	public List<DiariesContents> findDiariesByUserId(Integer userId);

	/**
	 * 日記/日記記事登録
	 * @param insertDiariesDto 日記情報
	 */
	public void createDiaryByUserId(InsertDiariesDto insertDiariesDto);
}
