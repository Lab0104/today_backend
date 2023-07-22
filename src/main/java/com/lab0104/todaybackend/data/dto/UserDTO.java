package com.lab0104.todaybackend.data.dto;

import io.swagger.annotations.ApiModel;
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
        private LocalDateTime updateAT;
    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("UserRequest")
    public static class Request{
        private String email;
        private String nickname;
        private String address;
        private double addressLatitude;
        private double addressLongitude;
        private float score;
        private String loginMethod;
        private String passwordKey;

    }

}
