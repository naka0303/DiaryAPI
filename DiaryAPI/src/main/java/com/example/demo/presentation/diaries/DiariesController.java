package com.example.demo.presentation.diaries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.diaries.dto.InsertDiariesDto;
import com.example.demo.domain.diariesContents.entity.DiariesContents;
import com.example.demo.infrastructure.diaries.request.RegisterDiaryRequest;
import com.example.demo.infrastructure.diaries.service.DiariesService;

import jakarta.validation.ValidationException;

/**
 * 日記APIコントローラー.
 */
@RestController
public class DiariesController {
  
  @Autowired
  DiariesService diariesService;
  
  /**
   * 日記情報一覧取得.
   *
   * @param userId ユーザーID
   *
   * @return 日記情報
   */
  @GetMapping("/v1/diaries/{userId}")
  public ResponseEntity<List<InsertDiariesDto>> findDiariesByUserId(
      @PathVariable Integer userId) {
    
    List<DiariesContents> diariesContents = diariesService.findDiariesByUserId(userId);
    
    return new ResponseEntity(diariesContents, HttpStatus.OK);
  }
  
  /**
   * 日記登録.
   *
   * @param registerDiaryRequest 日記登録情報
   *
   * @throws Exception 例外処理
   */
  @PostMapping("/v1/diaries")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> createDiaryByUserId(
      @Validated @RequestBody RegisterDiaryRequest registerDiaryRequest,
      BindingResult result) throws Exception {
    
    if (result.hasErrors()) {
      throw new ValidationException();
    }
    
    diariesService.createDiaryByUserId(registerDiaryRequest);
    
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
