package com.example.demo.infrastructure.diaries.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.application.diaries.dto.InsertDiariesDto;
import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.mapper.DiariesCommandMapper;
import com.example.demo.mapper.DiariesQueryMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DiariesRepositoryImpl implements DiariesRepository {
	
	private final DiariesQueryMapper diariesQueryMapper;
	
	private final DiariesCommandMapper diariesCommandMapper;
	
	/**
	 * 日情報一覧取得
	 * @return 日記情報
	 */
	public List<DiariesContents> findDiariesByUserId(Integer userId) {
		return diariesQueryMapper.findDiariesByUserId(userId);
	}

	/**
	 * 日記/日記記事登録
	 * @param diariesDto 日記情報
	 */
	public void createDiaryByUserId(InsertDiariesDto diariesDto) {
		
		// TODO: あとでuser_idとdiary_idチェック行う
		if (diariesDto.getDiaryId() != 1) {
			diariesCommandMapper.insertDiaryByUserId(diariesDto);
		}
		
		diariesCommandMapper.insertContentByUserId(diariesDto);
	}
}
