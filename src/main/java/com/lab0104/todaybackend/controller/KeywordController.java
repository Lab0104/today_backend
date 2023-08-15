package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.KeywordDTO;
import com.lab0104.todaybackend.service.KeywordService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/keyword")
public class KeywordController {
    final private KeywordService keywordService;


    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "키워드 조회", notes = "id에 해당하는 키워드 조회")
    // http method 에 대한 api 정보
    @ApiImplicitParam(name = "id", value = "키워드 별 아이디 값",dataType = "String")
    // Api의 매개변수를 설명 및 문서화하는 어노테이션
    // id 값을 통해서 페이지 출력
    public ResponseEntity<KeywordDTO.Info> getKeyword(@PathVariable Long id) {
        KeywordDTO.Info keywordDTO = keywordService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(keywordDTO);
    } // ResponseEntity<>( message, headers, HttpStatus )

    @PostMapping
    @ApiOperation(value = "키워드 생성", notes = "요청에 따른 키워드 값 생성")
    public ResponseEntity<KeywordDTO.Info> CreateKeyword(@RequestBody KeywordDTO.Request request) {
        KeywordDTO.Info createKey = keywordService.save(request);

        return ResponseEntity.status(HttpStatus.OK).body(createKey);
    } // 키워드를 db에 저장하고 리턴

    @PutMapping
    @ApiOperation(value = "키워드 업데이트", notes = "생성되어 있는 키워드 id값을 통해서 요청된 키워드로 변경")
    @ApiImplicitParam(name = "requestId", value = "요청들어온 키워드 값", dataType = "String")
    public ResponseEntity<KeywordDTO.Info> UpdateKeyword(long id, @RequestBody KeywordDTO.Request request) {
        KeywordDTO.Info updateKeyword = keywordService.update(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(updateKeyword);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "키워드 삭제", notes = "현재 생성되어 있는 키워드를 삭제한다")
    @ApiImplicitParam(name = "id", value = "현재 생성되어져 있는 아이디 값을 가져옴")
    // id 값으로 삭제된 페이지 추적
    public ResponseEntity<String> deleteKeyword(@PathVariable long id) throws Exception {
        keywordService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("키워드 삭제가 완료되었습니다.");
    }
}
