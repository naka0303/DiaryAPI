package com.example.demo.mapper;

import com.example.demo.application.exchange.dto.FindCommentLinkedUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExchangeQueryMapper {

  /**
   * 指定された日記のコメントを全て取得
   *
   * @param diaryId 日記ID
   * @return コメント情報
   */
  List<FindCommentLinkedUserDto> findComments(Integer diaryId);
}
