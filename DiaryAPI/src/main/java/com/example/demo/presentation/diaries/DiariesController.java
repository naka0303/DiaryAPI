package com.example.demo.presentation.diaries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.diaries.dto.InsertDiariesDto;
import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.infrastructure.diaries.service.DiariesService;

@RestController
public class DiariesController {
	
	@Autowired
	DiariesService diariesService;
	
	/**
	 * 日記情報一覧取得
	 * @param userId ユーザーID
	 * @return 日記情報
	 */
	@GetMapping("/v1/diaries/{userId}")
	public ResponseEntity<List<InsertDiariesDto>> findDiariesByUserId(
			@PathVariable Integer userId) {
		
		List<DiariesContents> diariesContents = diariesService.findDiariesByUserId(userId);
		
		return new ResponseEntity(diariesContents, HttpStatus.OK);
	}
	
	/**
	 * 日記/日記記事登録
	 * @param userId ユーザーID
	 * @param diariesDto 日記情報
	 * @throws Exception 
	 */
	@PostMapping("/v1/diaries")
	public ResponseEntity<InsertDiariesDto> createDiaryByUserId(
			@Validated @RequestBody InsertDiariesDto insertDiariesDto) throws Exception{
		
		if (insertDiariesDto == null) {
			throw new Exception();
		}
		
		diariesService.createDiaryByUserId(insertDiariesDto);
		
		return new ResponseEntity(null, HttpStatus.CREATED);
	}
}
