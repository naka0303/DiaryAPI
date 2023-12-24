package com.example.demo.domain.diaryUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiaryUserService {
	
	@Autowired
	DiaryUserRepository diaryUserRepository;
	
	public List<DiaryUser> findAll() {
		return diaryUserRepository.findAll();
	}
}
