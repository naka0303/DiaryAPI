package com.example.demo.infrastructure.diary.service;

import com.example.demo.application.diary.dto.FindDiaryDto;
import com.example.demo.application.diary.dto.FindDiaryLinkedUserDto;
import com.example.demo.infrastructure.diary.repository.DiaryQueryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * DiaryQueryServiceImplクラス.
 */
@Service
public class DiaryQueryServiceImpl implements DiaryQueryService {

  private final DiaryQueryRepository diaryQueryRepository;
  
  public DiaryQueryServiceImpl(
          DiaryQueryRepository diaryQueryRepository) {
      this.diaryQueryRepository = diaryQueryRepository;
  }

  /**
   * 指定されたユーザーIDに紐づく日記情報取得.
   *
   * @param userId ユーザーID
   * @return ユーザーIDに紐づく日記情報
   */
  @Override
  public List<FindDiaryDto> findDiariesByUserId(Integer userId) {

    // 指定されたユーザーIDに紐づく日記IDを取得
    List<FindDiaryLinkedUserDto> diaryLinkedUserDtoList =
            diaryQueryRepository.findDiariesLinkedUser(userId);
    
    List<FindDiaryDto> diaryDtoList = new ArrayList<>();
    for (FindDiaryLinkedUserDto dto : diaryLinkedUserDtoList) {
      FindDiaryDto diaryDto = diaryQueryRepository.findDiaryById(dto.getDiaryId());
      
      diaryDtoList.add(diaryDto);
    }

    return diaryDtoList;
  }

  /**
   * 指定された日記IDの日記情報取得.
   *
   * @param diaryId 日記ID
   * @return 指定された日記IDの日記情報
   */
  @Override
  public FindDiaryDto findDiaryById(Integer diaryId) {
    return diaryQueryRepository.findDiaryById(diaryId);
  }
}
