package com.example.demo.application.users.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * UpdateUsersDtoクラス.
 */
@Setter
@Getter
@NoArgsConstructor
public class UpdateUsersDto {

  @NonNull
  @NotBlank
  private String username;

  @NonNull
  private Integer age;

  @NonNull
  @NotBlank
  private String email;
  
  @NonNull
  @NotBlank
  private String password;

  @NonNull
  @NotBlank
  private String auth;

  /**
   * コンストラクタ.
   *
   * @param username ユーザー名
   * @param age 年齢
   * @param email メールアドレス
   * @param password パスワード
   * @param auth 権限
   */
  public UpdateUsersDto(
      String username,
      Integer age,
      String email,
      String password,
      String auth) {
    this.username = username;
    this.age = age;
    this.email = email;
    this.password = password;
    this.auth = auth;
  }
}
