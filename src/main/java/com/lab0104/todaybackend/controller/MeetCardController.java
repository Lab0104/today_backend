package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.service.MeetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequestMapping("v1/meet/card")
public class MeetCardController {
    final private MeetService meetService;

    public MeetCardController(MeetService meetService) {
        this.meetService = meetService;
    }

    @GetMapping(value = "/main/list/{number}/{size}")
    @ApiOperation(value = "메인페이지 모임카드 전체 리스트 조회", notes = "메인페이지 모임카드 전체를 조회합니다.")
    public ResponseEntity<List<MeetDTO.MainCard>> getMainCardList(@PathVariable int number, @PathVariable int size){
        List<MeetDTO.MainCard> pageRequestDTO = meetService.findListForMainCard(number, size);
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }

    @GetMapping(value = "/main/list/category/{number}/{size}/{categoryId}")
    @ApiOperation(value = "메인 페이지 모임 카드 카테고리 별 리스트 조회", notes = "메인페이지 모임카드를 카테고리 별로 조회합니다.")
    public ResponseEntity<List<MeetDTO.MainCard>> getMainCardListByCategory(@PathVariable int number, @PathVariable int size, @PathVariable long categoryId){
        List<MeetDTO.MainCard> pageRequestDTO = meetService.findMainCardListByCategory(number, size, categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }

    @GetMapping(value = "/map/{number}/{size}/{keyword}")
    @ApiOperation(value = "작성자 별 모임글 리스트 조회", notes = "작성자 id를 사용하여 특정 사용자가 작성한 모임글을 최신 순으로 조회합니다.")
    public ResponseEntity<List<MeetDTO.MapCard>> getMapCardList(
            @PathVariable int number,
            @PathVariable int size,
            @PathVariable String keyword){
        List<MeetDTO.MapCard> pageRequestDTO = meetService.findListForMapCard(number, size, keyword);
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }

}
