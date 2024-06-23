package com.example.demo.presentation.diaryContent;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;
import com.example.demo.domain.contents.entity.Content;
import com.example.demo.infrastructure.contents.service.DiaryContentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 日記記事APIコントローラー.
 */
@RestController
public class DiaryContentController {

    @Autowired
    DiaryContentQueryService diaryContentQueryService;

    /**
     * 日記記事情報取得.
     *
     * @param diaryId 日記ID
     *
     * @return 日記情報
     */
    @GetMapping("/v1/contents/{diaryId}")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<List<Content>> findDiaryContentByUserId(
            @PathVariable Integer diaryId) {

        Content content = new Content();

        List<FindDiaryContentDto> dtoList =
                diaryContentQueryService.findDiaryContentByDiaryId(diaryId);

        return new ResponseEntity(content.toEntity(dtoList), HttpStatus.OK);
    }
}
