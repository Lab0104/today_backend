package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.KeywordDTO;
import com.lab0104.todaybackend.service.KeywordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/keyword")
public class KeywordController {
    final private KeywordService keywordService;


    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    public ResponseEntity<KeywordDTO.Info> getKeyword(@PathVariable Long id) {
        KeywordDTO.Info keywordDTO = keywordService.findOne(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body();
    } // ResponseEntity<>( message, headers, HttpStatus )
}
