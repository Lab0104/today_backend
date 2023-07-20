package com.lab0104.todaybackend.data.dto;

import com.lab0104.todaybackend.data.domain.Meet;
import com.lab0104.todaybackend.data.domain.Member;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberDTO {

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("MemberInfo")
    public static class Info{
        private long id;
        private String status;
        private String meetName;
        private String userName;
    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("MemberRequest")
    public static class Request{
        private String status;
        private long meet;
        private long user;
        }

    public static Info MemberEntityToDTOList(Member member){
        return Info.builder()
                .id(member.getId())
                .meetName(member.getMeet().getTitle())
                .userName(member.getUser().getNickname())
                .status(member.getStatus())
                .build();
    }


}

