package com.example.demo.infrastructure.login.request;

import lombok.Data;

/**
 * LoginUserRequestクラス.
 */
@Data
public class LoginUserRequest {
  
  private String username;
  
  private String password;
}
