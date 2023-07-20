package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.CategoryDTO;
import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.data.dto.MemberDTO;
import com.lab0104.todaybackend.data.repository.MemberRepository;
import com.lab0104.todaybackend.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/member")
public class MemberController {
        final private MemberService memberService;

        private MemberController(MemberService memberService){
            this.memberService = memberService;
        }

    @GetMapping(value = "/list")
    @ApiOperation(value = "")
    public ResponseEntity<List<MemberDTO.Info>> getMemberList(int meetId){
        List<MemberDTO.Info> pageRequestDTO = memberService.findByMeet(meetId);
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "")
    public ResponseEntity<MemberDTO.Info> createMember(@RequestBody MemberDTO.Request memberDTO) {
        MemberDTO.Info createCategoryDTO = memberService.save(memberDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createCategoryDTO);
    }

    @DeleteMapping
    @ApiOperation(value = "/delete")
    public ResponseEntity<String> deleteMember(Long id) throws Exception {
        memberService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
