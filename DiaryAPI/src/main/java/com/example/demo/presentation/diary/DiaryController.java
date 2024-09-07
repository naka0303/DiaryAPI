package com.example.demo.presentation.diary;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.domain.diary.entity.Diary;
import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
import com.example.demo.infrastructure.diary.request.UpdateDiaryRequest;
import com.example.demo.infrastructure.diary.service.DiaryCommandService;
import com.example.demo.infrastructure.diary.service.DiaryQueryService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日記APIコントローラー.
 */
@RestController
public class DiaryController {

  @Autowired
  DiaryQueryService diaryQueryService;

  @Autowired
  DiaryCommandService diaryCommandService;

  /**
   * 全ての日記情報取得.
   *
   * @return 日記情報
   * @throws Exception
   */
  @GetMapping("/v1/diaries")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<List<Diary>> findDiaries() throws Exception {

    Diary diary = new Diary();

    List<FindDiaryDto> dtoList =
        diaryQueryService.findDiaries();

    return new ResponseEntity(diary.toEntityList(dtoList), HttpStatus.OK);
  }

  /**
   * 指定されたユーザーに紐づく日記情報取得.
   *
   * @param userId ユーザーID
   * @return ユーザーIDに紐づく日記情報
   */
  @GetMapping("/v1/users/{userId}/diaries")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<List<Diary>> findDiariesByUser(
      @PathVariable Integer userId) throws Exception {

    Diary diary = new Diary();

    List<FindDiaryDto> dtoList =
        diaryQueryService.findDiariesByUser(userId);

    return new ResponseEntity(diary.toEntityList(dtoList), HttpStatus.OK);
  }

  /**
   * 指定された日記情報取得.
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   * @return 指定された日記情報
   */
  @GetMapping("/v1/users/{userId}/diaries/{diaryId}")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<List<Diary>> findDiaryByUser(
      @PathVariable Integer userId,
      @PathVariable Integer diaryId) {

    Diary diary = new Diary();

    FindDiaryDto dto =
        diaryQueryService.findDiaryByUser(userId, diaryId);

    return new ResponseEntity(diary.toEntity(dto), HttpStatus.OK);
  }

  /**
   * 日記登録.
   *
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  @PostMapping("/v1/users/{userId}/diaries")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> registerDiary(
      @PathVariable Integer userId,
      @Validated @RequestBody RegisterDiaryRequest request,
      BindingResult result) throws Exception {

    if (result.hasErrors()) {
      throw new ValidationException();
    }

    diaryCommandService.registerDiary(userId, request);

    return ResponseEntity.ok(HttpStatus.OK);
  }

  /**
   * 日記更新.
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  @PutMapping("/v1/users/{userId}/diaries/{diaryId}")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> updateDiary(
      @PathVariable Integer userId,
      @PathVariable Integer diaryId,
      @Validated @RequestBody UpdateDiaryRequest request,
      BindingResult result) throws Exception {

    if (result.hasErrors()) {
      throw new ValidationException();
    }

    diaryCommandService.updateDiary(userId, diaryId, request);

    return ResponseEntity.ok(HttpStatus.OK);
  }

  /**
   * 日記削除.
   *
   * @param userId ユーザーID
   * @param diaryId 日記ID
   * @throws Exception 例外処理
   */
  @DeleteMapping("/v1/users/{userId}/diaries/{diaryId}")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> deleteDiary(
      @PathVariable Integer userId,
      @PathVariable Integer diaryId) throws Exception {

    diaryCommandService.deleteDiary(userId, diaryId);

    return ResponseEntity.ok(HttpStatus.OK);
  }

}
