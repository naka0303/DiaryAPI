package com.example.demo.application.diaries.dto;

import java.util.List;

import com.example.demo.domain.diariesContents.entity.DiariesContents;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindDiariesDto {
	
	private Integer diaryId;
	
	private Integer userId;
	
	private String diaryTitile;
	
	private String diaryContent;
	
	/**
	 * 日記/記事情報DTO変換
	 * @param diaries 日記/記事情報結合エンティティリスト
	 * @return 日記/記事情報DTO
	 */
	public FindDiariesDto toDto(List<DiariesContents> diariesContents) {
		FindDiariesDto dto = new FindDiariesDto();
		
		for (DiariesContents diaryContent : diariesContents) {
			dto.setDiaryId(diaryContent.getDiaryId());
			dto.setDiaryTitile(diaryContent.getDiaryTitle());
			dto.setDiaryContent(diaryContent.getDiaryContent());
			dto.setUserId(diaryContent.getUserId());
		}
		
		return dto;
	}
}
