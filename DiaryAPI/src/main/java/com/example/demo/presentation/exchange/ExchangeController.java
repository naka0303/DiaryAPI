package com.example.demo.presentation.exchange;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.infrastructure.diary.request.RegisterDiaryRequest;
import com.example.demo.infrastructure.diary.request.UpdateDiaryRequest;
import com.example.demo.infrastructure.diary.service.DiaryCommandService;
import com.example.demo.infrastructure.diary.service.DiaryQueryService;
import com.example.demo.infrastructure.exchange.request.RegisterCommentRequest;
import com.example.demo.infrastructure.exchange.service.ExchangeCommandService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日記交流所APIコントローラー.
 */
@RestController
public class ExchangeController {

  @Autowired
  ExchangeCommandService exchangeCommandService;

  /**
   * コメント投稿
   * @param diaryId 日記ID
   * @param request コメント登録内容
   * @param result
   * @return
   * @throws Exception
   */
  @PostMapping("/v1/diaries/{diaryId}/comments")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> registerComment(
      @PathVariable Integer diaryId,
      @Validated @RequestBody RegisterCommentRequest request,
      BindingResult result) throws Exception {

    if (result.hasErrors()) {
      throw new ValidationException();
    }

    // コメント投稿
    exchangeCommandService.registerComment(
        diaryId, request);

    return ResponseEntity.ok(HttpStatus.OK);
  }
}
