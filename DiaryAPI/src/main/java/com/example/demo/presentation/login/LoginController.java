package com.example.demo.presentation.login;

import com.example.demo.application.login.dto.PrincipalDto;
import com.example.demo.infrastructure.users.service.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.infrastructure.login.request.LoginUserRequest;
import com.example.demo.infrastructure.users.service.UserLoginService;

import java.security.Principal;

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
  public UserPrincipal login(
      @RequestBody LoginUserRequest request) throws Exception {
    
    // 処理を実行
    UserPrincipal userPrincipal = userLoginService. login(request);

    return userPrincipal;
  }
}