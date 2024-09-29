package com.example.demo.domain.diary_linked_user;

import com.example.demo.application.diary.dto.FindDiaryLinkedUserDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DiaryLinkedUserData {

	private Integer diaryId;

	private String diaryTitle;

	private String diaryContent;

	private Integer userId;

	private String username;

	private Integer age;

	private String email;

	private String auth;

	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Tokyo")
	private LocalDateTime createdAt;

	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Tokyo")
	private LocalDateTime updatedAt;

	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Tokyo")
	private LocalDateTime deletedAt;

	/**
	 * エンティティ変換
	 * @param dto FindDiaryLinkedUserDto
	 * @return DiaryLinkedUserDataエンティティ
	 */
	public DiaryLinkedUserData toEntity(FindDiaryLinkedUserDto dto) {
		DiaryLinkedUserData data = new DiaryLinkedUserData();

		data.setDiaryId(dto.getDiaryId());
		data.setDiaryTitle(dto.getDiaryTitle());
		data.setDiaryContent(dto.getDiaryContent());
		data.setUserId(dto.getUserId());
		data.setUsername(dto.getUsername());
		data.setAge(dto.getAge());
		data.setAuth(dto.getAuth());
		data.setEmail(dto.getEmail());
		data.setCreatedAt(dto.getCreatedAt());
		data.setUpdatedAt(dto.getUpdatedAt());
		data.setDeletedAt(dto.getDeletedAt());

		return data;
	}

	/**
	 * エンティティリスト変換
	 * @param dtoList FindDiaryLinkedUserDtoリスト
	 * @return DiaryLinkedUserDataエンティティリスト
	 */
	public List<DiaryLinkedUserData> toEntityList(
			List<FindDiaryLinkedUserDto> dtoList) {
		List<DiaryLinkedUserData> dataList = new ArrayList<>();

		for (FindDiaryLinkedUserDto dto : dtoList) {
			DiaryLinkedUserData data = new DiaryLinkedUserData();

			data.setDiaryId(dto.getDiaryId());
			data.setDiaryTitle(dto.getDiaryTitle());
			data.setDiaryContent(dto.getDiaryContent());
			data.setUserId(dto.getUserId());
			data.setUsername(dto.getUsername());
			data.setAge(dto.getAge());
			data.setAuth(dto.getAuth());
			data.setEmail(dto.getEmail());
			data.setCreatedAt(dto.getCreatedAt());
			data.setUpdatedAt(dto.getUpdatedAt());
			data.setDeletedAt(dto.getDeletedAt());

			dataList.add(data);
		}

		return dataList;
	}
}
