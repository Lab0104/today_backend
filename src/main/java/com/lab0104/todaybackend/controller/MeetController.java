package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.service.MeetService;
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
@RequestMapping("/meet")
public class MeetController {

    final private MeetService meetService;

    public MeetController(MeetService meetService) {
        this.meetService = meetService;
    }


    @PostMapping
    @ApiOperation(value = "")
    public ResponseEntity<MeetDTO.Info> createMeet(@RequestBody MeetDTO.Request meetDTO) {
        MeetDTO.Info createMeetDTO = meetService.save(meetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createMeetDTO);
    }


    @GetMapping
    @ApiOperation(value = "")
    public ResponseEntity<MeetDTO.Info> getOneMeet(Long id){
        MeetDTO.Info getMeetDTO = meetService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(getMeetDTO);
    }

    @PutMapping
    @ApiOperation(value ="")
    public ResponseEntity<MeetDTO.Info>changMeet(long id, @RequestBody MeetDTO.Request meetDTO) throws Exception{
        meetService.update(id, meetDTO);
        MeetDTO.Info changeMeetDTO = meetService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(changeMeetDTO);
    }


    @DeleteMapping
    @ApiOperation(value = "category 삭제", notes = "id 값으로 삭제")
    public ResponseEntity<String> deleteUser(Long id) throws Exception {
        meetService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }


}
