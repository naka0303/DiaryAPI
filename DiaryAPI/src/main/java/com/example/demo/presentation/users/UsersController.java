package com.example.demo.presentation.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.users.dto.FindUsersDto;
import com.example.demo.application.users.dto.InsertUsersDto;
import com.example.demo.domain.users.entity.Users;
import com.example.demo.infrastructure.users.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	/**
	 * ユーザー情報一覧取得
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
	 * 新規ユーザー登録
	 * @param insertUsersDto ユーザー情報
	 */
	@PostMapping("/v1/users")
	public ResponseEntity<FindUsersDto> createUser(
			@Validated @RequestBody InsertUsersDto insertUsersDto){
		usersService.createUser(insertUsersDto);
		
		return new ResponseEntity(null, HttpStatus.CREATED);
	}
}
