package com.example.demo.infrastructure.exchange.repository;

import com.example.demo.application.exchange.dto.FindCommentLinkedUserDto;
import com.example.demo.application.exchange.dto.FindCommentReplyLinkedUserDto;
import com.example.demo.application.exchange.dto.FindReplyDto;
import com.example.demo.infrastructure.exchange.request.RegisterCommentRequest;
import com.example.demo.infrastructure.exchange.request.RegisterReplyRequest;
import com.example.demo.mapper.ExchangeCommandMapper;
import com.example.demo.mapper.ExchangeQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * DiaryCommandRepositoryImplクラス.
 */
@Repository
@RequiredArgsConstructor
public class ExchangeCommandRepositoryImpl implements ExchangeCommandRepository {

  private final ExchangeCommandMapper exchangeCommandMapper;

  private final ExchangeQueryMapper exchangeQueryMapper;

  /**
   * コメント投稿.
   *
   * @param diaryId 日記ID
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  @Override
  public void registerComment(
      Integer diaryId, RegisterCommentRequest request) throws Exception {

    // 指定された日記への全コメントを取得
    int commentNo = 0;
    List<FindCommentReplyLinkedUserDto> dtoList =
        exchangeQueryMapper.findCommentsReplies(diaryId);

    // コメントが存在する場合
    if (!dtoList.isEmpty()) {
      Integer targetCommentNo = dtoList.get(0).getCommentNo();
      if (targetCommentNo == null) {
        commentNo = 1;
      } else {
        commentNo = targetCommentNo + 1;
      }
    } else {
      commentNo = 1;
    }

    final int cnt = exchangeCommandMapper.insertComment(
        diaryId, commentNo, request.getCommentFrom(), request.getContent());
    if (cnt != 1) {
      throw new Exception("Register comment failed");
    }
  }

  /**
   * 返信投稿.
   *
   * @param diaryId 日記ID
   * @param request 登録内容
   * @throws Exception 例外処理
   */
  @Override
  public void registerReply(
      Integer diaryId, RegisterReplyRequest request) throws Exception {

    // 返信先のコメントが存在するか確認
    FindCommentLinkedUserDto findCommentLinkedUserDto =
        exchangeQueryMapper.findCommentsByComment(diaryId, request.getReplyTo());
    if (findCommentLinkedUserDto == null) {
      throw new Exception("Specified comment not found");
    }

    // コメントに紐づく返信を取得
    int replyNo = 0;
    final List<FindReplyDto> findReplyDtoList =
        exchangeQueryMapper.findRepliesByComment(diaryId, request.getReplyTo());

    if (findReplyDtoList.isEmpty()) {
      replyNo = 1;
    } else {
      final List<Integer> replyNoList = findReplyDtoList.stream()
          .map(FindReplyDto::getReplyNo).toList();
      if (!replyNoList.isEmpty()) {
        replyNo = Collections.max(replyNoList) + 1;
      } else {
        replyNo = 1;
      }
    }

    final int cnt = exchangeCommandMapper.insertReply(
        diaryId, replyNo, request.getReplyTo(), request.getReplyFrom(),
        request.getContent());
    if (cnt != 1) {
      throw new Exception("Register reply failed");
    }
  }
}
