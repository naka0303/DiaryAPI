package com.example.demo.presentation.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.user.entity.User;
import com.example.demo.infrastructure.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * ユーザー情報一覧を取得する
	 * @return ユーザー情報
	 */
	@GetMapping("/v1/users")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	/**
	 * 新規ユーザーを登録する
	 * @param user
	 * @return
	 */
	@PostMapping("/v1/users")
	public ResponseEntity<User> createUser(
			@Validated @RequestBody User user){
		
		userService.createUser(user);
		
		return new ResponseEntity(null, HttpStatus.CREATED);
	}
}
