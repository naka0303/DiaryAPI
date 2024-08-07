package com.example.demo.infrastructure.users.service;

import com.example.demo.application.login.dto.PrincipalDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.login.request.LoginUserRequest;
import com.example.demo.infrastructure.users.repository.UsersRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponse;

import java.security.Principal;
import java.util.stream.Collectors;

/**
 * UserLoginServiceクラス.
 */
@RequiredArgsConstructor
@Service
public class UserLoginService implements UserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(UserLoginService.class);
  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Autowired
  private AuthenticationManager authenticationManager;
 
  public UserLoginService(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users userByName = usersRepository.findUserByName(username);
    if (userByName == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return new UserPrincipal(userByName);
  }
  
  /**
   * 認証処理.
   *
   * @param request ログイン認証情報
   * @return 認証結果
   */
  public UserPrincipal login(LoginUserRequest request) throws Exception {
    Authentication authentication = null;
    PrincipalDto dto = new PrincipalDto();
    try {
      // ユーザー名でのユーザー情報取得
      UserDetails userDetail = loadUserByUsername(request.getUsername());
      
      // ユーザー名とパスワードでの認証
      Authentication result = new UsernamePasswordAuthenticationToken(
          userDetail.getUsername(), request.getPassword(), userDetail.getAuthorities());
          
      // ユーザ存在チェックし認証
      authentication =
          this.authenticationManager.authenticate(result);
      
      // 認証OKの場合は、認証結果をcontextholderに設定
      SecurityContextHolder.getContext().setAuthentication(authentication);
          
      // 認証済みユーザ情報を格納
      UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

      return userPrincipal;

    } catch (Exception e) {
      log.error(e.getMessage());
      // throw new Exception(e.getMessage());
      ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .contentType(MediaType.APPLICATION_JSON)
              .body(e.getMessage());
    }
    return null;
  }
}