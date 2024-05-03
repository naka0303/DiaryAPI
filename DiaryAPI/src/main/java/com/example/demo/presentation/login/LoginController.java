package com.example.demo.presentation.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
  @GetMapping("/v1/login")
  @CrossOrigin("http://localhost:4200")
  public String login() {
    
    // 認証処理を実行
    // Object authResult = this.userLoginService.login(request);
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    System.out.println(auth.getName());
    return "redirect:http://localhost:4200/users";
  }
}