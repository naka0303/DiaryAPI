package com.example.demo.infrastructure.diaryContent.service;


import com.example.demo.infrastructure.diaryContent.repository.DiaryContentCommandRepository;
import com.example.demo.infrastructure.diaryContent.request.RegisterDiaryContentRequest;
import org.springframework.stereotype.Service;

/**
 * DiaryContentCommandServiceImplクラス.
 */
@Service
public class DiaryContentCommandServiceImpl implements DiaryContentCommandService {
  
  private final DiaryContentCommandRepository diaryContentCommandRepository;
  
  public DiaryContentCommandServiceImpl(
          DiaryContentCommandRepository diaryContentCommandRepository) {
    this.diaryContentCommandRepository = diaryContentCommandRepository;
  }

  /**
   * 日記記事登録.
   * @param request 日記記事登録情報
   */
  @Override
  public void registerDiaryContentByUserId(RegisterDiaryContentRequest request) throws Exception {
    diaryContentCommandRepository.registerDiaryContentByUserId(request);
  }
}
