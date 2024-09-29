package com.example.demo.presentation.exchange;

import com.example.demo.application.exchange.dto.FindCommentReplyLinkedUserDto;
import com.example.demo.domain.comment.entity.CommentAndReplyLinkedUser;
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
   * 指定された日記のコメント/返信取得.
   * @param diaryId 日記ID
   * @return
   * @throws Exception
   */
  @GetMapping("/v1/diaries/{diaryId}/comments-replies")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> findCommentsReplies(
      @PathVariable Integer diaryId) throws Exception {

    CommentAndReplyLinkedUser commentLinkedUser = new CommentAndReplyLinkedUser();

    // コメント取得
    List<FindCommentReplyLinkedUserDto> dtoList =
        exchangeQueryService.findCommentsReplies(diaryId);

    return new ResponseEntity(commentLinkedUser.toEntityList(dtoList), HttpStatus.OK);
  }

  /**
   * コメント投稿.
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
    exchangeCommandService.registerComment(diaryId, request);

    return ResponseEntity.ok(HttpStatus.OK);
  }

  /**
   * 返信投稿.
   * @param diaryId 日記ID
   * @param commentNo コメント番号
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  @PostMapping("/v1/diaries/{diaryId}/comments/{commentNo}/replies")
  @CrossOrigin("http://localhost:4200")
  public ResponseEntity<Object> registerReply(
      @PathVariable Integer diaryId,
      @PathVariable Integer commentNo,
      @Validated @RequestBody RegisterReplyRequest request,
      BindingResult result) throws Exception {

    if (result.hasErrors()) {
      throw new ValidationException();
    }

    // コメント投稿
    exchangeCommandService.registerReply(diaryId, request);

    return ResponseEntity.ok(HttpStatus.OK);
  }
}
