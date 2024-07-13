package com.example.demo.domain.diary.entity;

import com.example.demo.application.diary.dto.FindDiaryDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "diaries")
@Data
public class Diary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diary_id")
	private Integer diaryId;

	@NotBlank
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * エンティティ変換
	 * @param dto FindDiaryDto
	 * @return Diaryエンティティ
	 */
	public Diary toEntity(FindDiaryDto dto) {
		Diary diary = new Diary();

		diary.setDiaryId(dto.getDiaryId());
		diary.setUserId(dto.getUserId());

		return diary;
	}

	/**
	 * エンティティリスト変換
	 * @param dtoList FindDiaryDtoリスト
	 * @return Diaryエンティティリスト
	 */
	public List<Diary> toEntityList(List<FindDiaryDto> dtoList) {
		List<Diary> diaryList = new ArrayList<>();

		for (FindDiaryDto dto : dtoList) {
			Diary diary = new Diary();

			diary.setDiaryId(dto.getDiaryId());
			diary.setUserId(dto.getUserId());

			diaryList.add(diary);
		}

		return diaryList;
	}
}
