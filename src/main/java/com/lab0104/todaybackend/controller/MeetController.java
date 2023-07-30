package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.service.MeetService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@RequestMapping("/v1/meet")
public class MeetController {

    final private MeetService meetService;

    public MeetController(MeetService meetService) {
        this.meetService = meetService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "모임글 1건 조회", notes = "id에 해당하는 모임글 1건의 상세 정보를 조회합니다.")
    @ApiImplicitParam(name = "id", value = "모임 생성 시 자동으로 발급되는 id")
    public ResponseEntity<MeetDTO.Info> getOneMeet(@PathVariable  Long id){
        MeetDTO.Info getMeetDTO = meetService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(getMeetDTO);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "모임글 1건 조회", notes = "id에 해당하는 모임글 1건의 상세 정보를 조회합니다.")
    @ApiImplicitParam(name = "id", value = "모임 생성 시 자동으로 발급되는 id")
    public ResponseEntity<MeetDTO.Info> getOneMeet(@PathVariable  Long id){
        MeetDTO.Info getMeetDTO = meetService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(getMeetDTO);
    }

    @PostMapping
    @ApiOperation(value = "모임글 생성", notes = "모임 글을 생성합니다.")
    public ResponseEntity<MeetDTO.Info> createMeet(@RequestBody MeetDTO.Request meetDTO) {
        MeetDTO.Info createMeetDTO = meetService.save(meetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createMeetDTO);
    }

    @PutMapping
    @ApiOperation(value = "모임글 수정", notes = "해당 id의 모임글 정보를 수정합니다.")
    @ApiImplicitParam(name = "id", value = "수정할 모임글의 id")
    public ResponseEntity<MeetDTO.Info>changMeet(@PathVariable long id, @RequestBody MeetDTO.Request meetDTO) throws Exception{
        meetService.update(id, meetDTO);
        MeetDTO.Info changeMeetDTO = meetService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(changeMeetDTO);
    }


    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "모임글 삭제", notes = "해당 id의 모임글을 삭제합니다.")
    @ApiImplicitParam(name = "id", value = "삭제할 모임글의 id")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws Exception {
        meetService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("모임글이 정상적으로 삭제되었습니다.");
    }


}
