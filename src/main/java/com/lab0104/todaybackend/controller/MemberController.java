package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.CategoryDTO;
import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.data.dto.MemberDTO;
import com.lab0104.todaybackend.data.dto.UserDTO;
import com.lab0104.todaybackend.data.repository.MemberRepository;
import com.lab0104.todaybackend.service.MemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("v1/member")
public class MemberController {
    final private MemberService memberService;
    private MemberController(MemberService memberService){
        this.memberService = memberService;
    }


    @GetMapping(value = "/list/{id}")
    @ApiOperation(value = "모임 참가자 조회", notes = "모임 id를 사용하여 모임 참가 신청자들을 조회합니다.")
    @ApiImplicitParam(name = "id", value = "모임 생성 시 자동으로 발급되는 id")
    public ResponseEntity<List<MemberDTO.Info>> getMemberList(@PathVariable int meetId){
        List<MemberDTO.Info> pageRequestDTO = memberService.findByMeet(meetId);
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }

    @PostMapping()
    @ApiOperation(value = "모임 신청", notes = "사용자의 id와 모임 id를 사용하여 모임 신청합니다.")
    public ResponseEntity<MemberDTO.Info> createMember(@RequestBody MemberDTO.Request memberDTO) {
        MemberDTO.Info createCategoryDTO = memberService.save(memberDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createCategoryDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "모임 신청 철회", notes = "모임 참가 신청 시 발급되었던 id를 사용하여 모임 참가 신청을 철회합니다.")
    @ApiImplicitParam(name = "id", value = "모임 참사 신청 시 자동으로 발급되는 id")
    public ResponseEntity<String> deleteMember(Long id) throws Exception {
        memberService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("모임이 신청이 취소되었습니다.");
    }
}
