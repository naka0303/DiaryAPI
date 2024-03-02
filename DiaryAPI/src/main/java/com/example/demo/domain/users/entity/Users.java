package com.example.demo.domain.users.entity;

import java.time.LocalDateTime;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Usersクラス.
 */
@Entity
@Table(name = "users")
@Data
public class Users {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer userId;
  
  @NotBlank
  @Column(name = "username")
  private String username;
  
  @NonNull
  @Column(name = "age")
  private Integer age;
  
  @NotBlank
  @Column(name = "email")
  private String email;
  
  @NonNull
  @Column(name = "password")
  private String password;
  
  @Column(name = "auth")
  private String auth;
  
  @Column(name = "diary_id")
  private Integer diaryId;
  
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
  
  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
}
