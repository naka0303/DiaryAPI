package com.example.demo.presentation.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.infrastructure.login.request.LoginUserRequest;
import com.example.demo.infrastructure.users.service.UserLoginService;

/**
 * LoginControllerクラス.
 */
@RestController
public class LoginController {
  
  @Autowired
  private UserLoginService userLoginService;
  
  /**
   * ログイン.
   */
  @PostMapping("/v1/login")
  @CrossOrigin("http://localhost:4200")
  public Object login(
      @RequestBody LoginUserRequest request) {
    
    // 処理を実行
    Object authResult = userLoginService.login(request);
    
    return authResult;
  }
}