package com.lab0104.todaybackend.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ProfileDTO {

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("ProfileInfo")
    public static class Info{
        private long id;
        private String backgroundUrl;
        private String profileUrl;
        private long user;

        //base entity
        private LocalDateTime createdAt;
        private LocalDateTime updateAt;
    }


    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("ProfileRequest")
    public static class Request{
        private String backgroundUrl;
        private String profileUrl;
        private long user;
    }
}
