package com.lab0104.todaybackend.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;


public class UserDTO {

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("UserInfo")
    public static class Info{
        private long id;

        private String email;
        private String nickname;
        private String address;
        private double addressLatitude;
        private double addressLongitude;
        private float score;
        private String loginMethod;
        private String passwordKey;

        //base entity
        private LocalDateTime createdAt;
        private LocalDateTime updateAt;
    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("UserRequest")
    public static class Request{

        @ApiModelProperty(example = "이메일")
        private String email;

        @ApiModelProperty(example = "사용자 별명")
        private String nickname;

        @ApiModelProperty(example = "주소")
        private String address;

        private double addressLatitude;
        private double addressLongitude;

        @ApiModelProperty(example = "로그인 방식")
        private String loginMethod;

        @ApiModelProperty(example = "비밀번호")
        private String passwordKey;
    }
}
