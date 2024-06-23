package com.example.demo.domain.content.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "contents")
@Data
public class Content {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "content_id")
	private Integer contentId;
	
	@NotBlank
	@Column(name = "diary_id")
	private Integer diaryId;
	
	@NotBlank
	@Column(name = "diary_title")
	private String diaryTitle;
	
	@NotBlank
	@Column(name = "diary_content")
	private String diaryContent;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	/**
	 * エンティティ変換
	 * @param dtoList dtoList
	 * @return 日記情報エンティティリスト
	 */
	public List<Content> toEntity(List<FindDiaryContentDto> dtoList) {
		List<Content> contentList = new ArrayList<>();

		for (FindDiaryContentDto dto : dtoList) {
			Content content = new Content();

			content.setContentId(dto.getContentId());
			content.setDiaryId(dto.getDiaryId());
			content.setDiaryTitle(dto.getDiaryTitle());
			content.setDiaryContent(dto.getDiaryContent());

			contentList.add(content);
		}

		return contentList;
	}
}
