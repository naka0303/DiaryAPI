package com.example.demo.domain.diary.entity;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
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
	@Column(name = "diary_title")
	private String diaryTitle;

	@NotBlank
	@Column(name = "diary_content")
	private String diaryContent;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Tokyo")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Tokyo")
	private LocalDateTime updatedAt;

	@Column(name = "deleted_at")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Tokyo")
	private LocalDateTime deletedAt;

	/**
	 * エンティティ変換
	 * @param dto FindDiaryDto
	 * @return Diaryエンティティ
	 */
	public Diary toEntity(FindDiaryDto dto) {
		Diary diary = new Diary();

		diary.setDiaryId(dto.getDiaryId());
		diary.setDiaryTitle(dto.getDiaryTitle());
		diary.setDiaryContent(dto.getDiaryContent());
		diary.setCreatedAt(dto.getCreatedAt());
		diary.setUpdatedAt(dto.getUpdatedAt());
		diary.setDeletedAt(dto.getDeletedAt());

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
			diary.setDiaryTitle(dto.getDiaryTitle());
			diary.setDiaryContent(dto.getDiaryContent());
			diary.setCreatedAt(dto.getCreatedAt());
			diary.setUpdatedAt(dto.getUpdatedAt());
			diary.setDeletedAt(dto.getDeletedAt());

			diaryList.add(diary);
		}

		return diaryList;
	}

	/**
	 * 日記IDの昇順にソート
	 * @return 日記リスト
	 */
	public List<FindDiaryDto> sort(List<FindDiaryDto> diaryList) {
		return diaryList.stream().sorted(Comparator.comparing(FindDiaryDto::getDiaryId)).toList();
	}
}
