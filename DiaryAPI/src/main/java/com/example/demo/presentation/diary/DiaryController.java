package com.example.demo.presentation.diary;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.domain.diary.entity.Diary;
import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
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
   * 指定されたユーザーIDに紐づく日記情報取得.
   *
   * @param userId ユーザーID
   * @return ユーザーIDに紐づく日記情報
   */
  @GetMapping("/v1/diaries")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<List<Diary>> findDiariesByUserId(
      @RequestParam Integer userId) {

    Diary diary = new Diary();

    List<FindDiaryDto> dtoList =
        diaryQueryService.findDiariesByUserId(userId);

    return new ResponseEntity(diary.toEntityList(dtoList), HttpStatus.OK);
  }

  /**
   * 指定された日記IDの日記情報取得.
   *
   * @param diaryId 日記ID
   * @return 指定された日記IDの日記情報
   */
  @GetMapping("/v1/diaries/{diaryId}")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<List<Diary>> findDiaryById(
      @PathVariable Integer diaryId) {

    Diary diary = new Diary();

    FindDiaryDto dto =
        diaryQueryService.findDiaryById(diaryId);

    return new ResponseEntity(diary.toEntity(dto), HttpStatus.OK);
  }

  /**
   * 日記登録.
   *
   * @param request 日記情報
   * @throws Exception 例外処理
   */
  @PostMapping("/v1/diaries")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> registerDiaryByUserId(
      @Validated @RequestBody RegisterDiaryRequest request,
      BindingResult result) throws Exception {

    if (result.hasErrors()) {
      throw new ValidationException();
    }

    diaryCommandService.registerDiary(request);

    return ResponseEntity.ok(HttpStatus.OK);
  }
}
