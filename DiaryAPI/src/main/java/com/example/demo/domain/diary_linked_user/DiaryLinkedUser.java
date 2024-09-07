package com.example.demo.domain.diary_linked_user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "diaries_linked_users")
@Data
public class DiaryLinkedUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diary_id")
	private Integer diaryId;

	@NotBlank
	@Column(name = "user_id")
	private Integer userId;
}
