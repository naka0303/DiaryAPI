package com.example.demo.presentation.diaryContent;

import com.example.demo.application.diaryContent.dto.FindDiaryContentDto;
import com.example.demo.domain.content.entity.Content;
import com.example.demo.infrastructure.diaryContent.request.RegisterDiaryContentRequest;
import com.example.demo.infrastructure.diaryContent.service.DiaryContentCommandService;
import com.example.demo.infrastructure.diaryContent.service.DiaryContentQueryService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日記記事APIコントローラー.
 */
@RestController
public class DiaryContentController {

    @Autowired
    DiaryContentQueryService diaryContentQueryService;

    @Autowired
    DiaryContentCommandService diaryContentCommandService;

    /**
     * 日記記事情報取得.
     *
     * @param diaryId 日記ID
     *
     * @return 日記情報
     */
    @GetMapping("/v1/diary-contents/{diaryId}")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<List<Content>> findDiaryContentByUserId(
            @PathVariable Integer diaryId) {

        Content content = new Content();

        List<FindDiaryContentDto> dtoList =
                diaryContentQueryService.findDiaryContentByDiaryId(diaryId);

        return new ResponseEntity(content.toEntity(dtoList), HttpStatus.OK);
    }

    /**
     * 日記記事登録.
     *
     * @param request 日記登録情報
     *
     * @throws Exception 例外処理
     */
    @PostMapping("/v1/diary-contents")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Object> registerDiaryContentByUserId(
            @Validated @RequestBody RegisterDiaryContentRequest request,
            BindingResult result) throws Exception {

        if (result.hasErrors()) {
            throw new ValidationException();
        }

        diaryContentCommandService.registerDiaryContentByUserId(request);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
