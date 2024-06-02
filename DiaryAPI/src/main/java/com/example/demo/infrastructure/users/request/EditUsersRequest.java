package com.example.demo.infrastructure.users.request;

import lombok.Data;

/**
 * EditUsersRequestクラス.
 */
@Data
public class EditUsersRequest {
  
  private String username;

  private Integer age;

  private String email;

  private String auth;
}
