package com.example.demo.mapper;

import com.example.demo.domain.diary_linked_user.DiaryLinkedUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ExchangeCommandMapperクラス.
 */
@Mapper
public interface ExchangeCommandMapper {

  /**
   * コメント投稿.
   *
   * @param diaryId 日記ID
   * @param userId  ユーザーID
   * @param comment コメント登録内容
   * @throws Exception 例外処理
   */
  int insertComment(
      @Param("diaryId") Integer diaryId,
      @Param("userId") Integer userId,
      @Param("comment") String comment);
}