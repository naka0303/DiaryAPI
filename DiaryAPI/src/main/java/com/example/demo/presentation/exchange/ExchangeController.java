package com.example.demo.presentation.exchange;

import com.example.demo.application.exchange.dto.FindCommentLinkedUserDto;
import com.example.demo.domain.comment.entity.CommentLinkedUser;
import com.example.demo.infrastructure.exchange.request.RegisterCommentRequest;
import com.example.demo.infrastructure.exchange.request.RegisterReplyRequest;
import com.example.demo.infrastructure.exchange.service.ExchangeCommandService;
import com.example.demo.infrastructure.exchange.service.ExchangeQueryService;
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

  @Autowired
  ExchangeQueryService exchangeQueryService;

  /**
   * 指定された日記のコメント取得
   * @param diaryId 日記ID
   * @return
   * @throws Exception
   */
  @GetMapping("/v1/diaries/{diaryId}/comments")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> findComments(
      @PathVariable Integer diaryId) throws Exception {

    CommentLinkedUser commentLinkedUser = new CommentLinkedUser();

    // コメント取得
    List<FindCommentLinkedUserDto> dtoList =
        exchangeQueryService.findComments(diaryId);

    return new ResponseEntity(commentLinkedUser.toEntityList(dtoList), HttpStatus.OK);
  }

  /**
   * コメント投稿
   * @param diaryId 日記ID
   * @param request 登録内容
   * @throws Exception 例外処理
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

  @PostMapping("/v1/diaries/{diaryId}/comments/{commentId}/reply")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> registerReply(
      @PathVariable Integer diaryId,
      @PathVariable Integer commentId,
      @Validated @RequestBody RegisterReplyRequest request,
      BindingResult result) throws Exception {

    if (result.hasErrors()) {
      throw new ValidationException();
    }

    // コメント返信
    exchangeCommandService.registerReply(
        diaryId, commentId, request);

    return ResponseEntity.ok(HttpStatus.OK);
  }
}
