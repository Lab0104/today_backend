package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.service.MeetService;
import io.swagger.annotations.ApiImplicitParam;
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
@RequestMapping("v1/meet/list")
@ApiOperation(value = "",
        notes = "number = 페이지 넘버, 0번부터 시작 \n" +
                "size = 각 페이지 별로 출력되는 모임글 갯수 \n" +
                "[경고] 출력할 데이터가 없는 경우 [](null) 반환")
public class MeetListController {
    final private MeetService meetService;
    public MeetListController(MeetService meetService) {
        this.meetService = meetService;
    }

    @GetMapping
    @ApiOperation(value = "모임글 전체 리스트 조회", notes = "최신글 순으로 모임글 전체를 조회합니다.")
    public ResponseEntity<List<MeetDTO.Info>> getMeetList(@PathVariable int number, @PathVariable int size){
        List<MeetDTO.Info> pageRequestDTO = meetService.findList(number, size);
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }

    @GetMapping(value = "/category")
    @ApiOperation(value = "카테고리 별 모임글 리스트 조회", notes = "카테고리 별 모임글을 최신 순으로 조회합니다.")
    public ResponseEntity<List<MeetDTO.Info>> getMeetListByCategory(
            @PathVariable int number,
            @PathVariable int size,
            @PathVariable long categoryId){
        List<MeetDTO.Info> pageRequestDTO = meetService.findListByCategory(number, size, categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }

    @GetMapping(value = "/user")
    @ApiOperation(value = "작성자 별 모임글 리스트 조회", notes = "작성자 id를 사용하여 특정 사용자가 작성한 모임글을 최신 순으로 조회합니다.")
    public ResponseEntity<List<MeetDTO.Info>> getMeetListByUser(int number, int size, @PathVariable long userId){
        List<MeetDTO.Info> pageRequestDTO = meetService.findListByUser(number, size, userId);
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }
}
