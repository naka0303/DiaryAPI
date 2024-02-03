package com.example.demo.infrastructure.diaries.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.application.diaries.dto.InsertDiariesDto;
import com.example.demo.domain.diariesContents.entity.DiariesContents;

@Service
public interface DiariesService {
	
	/**
	 * 日記情報一覧取得
	 * @param userId ユーザーID
	 * @return 日記情報
	 */
	public List<DiariesContents> findDiariesByUserId(Integer userId);

	/**
	 * 日記登録
	 * @param diariesDto 日記情報
	 */
	public void createDiaryByUserId(InsertDiariesDto diariesDto);
}
