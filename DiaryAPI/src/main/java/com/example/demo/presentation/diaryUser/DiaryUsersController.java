package com.example.demo.presentation.diaryUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.diaryUser.DiaryUser;
import com.example.demo.domain.diaryUser.DiaryUserService;

@RestController
@RequestMapping
public class DiaryUsersController {
	
	@Autowired
	DiaryUserService diaryUserService;
	
	@GetMapping("/diary_users")
	public List<DiaryUser> findAll() {
		return diaryUserService.findAll();
	}
}
