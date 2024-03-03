package com.example.demo.presentation.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.users.dto.FindUsersDto;
import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.request.EditUsersRequest;
import com.example.demo.infrastructure.users.request.RegisterUsersRequest;
import com.example.demo.infrastructure.users.service.UsersService;

import jakarta.validation.ValidationException;

/**
 * ユーザーAPIコントローラー.
 */
@RestController
public class UsersController {
  
  @Autowired
  UsersService usersService;
  
  /**
   * ユーザー情報一覧取得.
   *
   * @return ユーザー情報
   */
  @GetMapping("/v1/users")
  public ResponseEntity<List<FindUsersDto>> findUsers() {
    List<Users> users = usersService.findUsers();
    List<FindUsersDto> usersDtoList =
        users.stream().map(FindUsersDto::toDto).collect(Collectors.toList());
    
    return new ResponseEntity(usersDtoList, HttpStatus.OK);
  }
  
  /**
   * 特定ユーザー情報取得.
   *
   * @param userId ユーザーID
   *
   * @return ユーザー情報
   */
  @GetMapping("/v1/users/{userId}")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<FindUsersDto> findUserId(
      @PathVariable Integer userId) {
    Users user = usersService.findUserById(userId);
    FindUsersDto userDto = FindUsersDto.toDto(user);
    
    return new ResponseEntity(userDto, HttpStatus.OK);
  }
  
  /**
   * 特定ユーザー情報編集.
   *
   * @param userId ユーザーID
   * @param editUsersRequest 編集ユーザー情報
   */
  @PutMapping("/v1/users/{userId}")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> findUserById(
      @PathVariable Integer userId,
      @Validated @RequestBody EditUsersRequest editUsersRequest,
      BindingResult result) {
    
    if (result.hasErrors()) {
      throw new ValidationException();
    }
    
    usersService.editUserById(userId, editUsersRequest);
    
    return ResponseEntity.ok(HttpStatus.OK);
  }
  
  /**
   * ユーザー登録.
   *
   * @param registerUsersRequest 登録ユーザー情報
   */
  @PostMapping("/v1/users")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> createUser(
      @Validated @RequestBody RegisterUsersRequest registerUsersRequest,
      BindingResult result) {
    
    if (result.hasErrors()) {
      throw new ValidationException();
    }
    
    usersService.createUser(registerUsersRequest);
    
    return ResponseEntity.ok(HttpStatus.OK);
  }
  
  /**
   * 特定ユーザー情報削除.
   *
   * @param userId ユーザーID
   */
  @DeleteMapping("/v1/users/{userId}")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> deleteUserByUserId(
      @PathVariable Integer userId) {
    
    usersService.deleteUserByUserId(userId);
    
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
