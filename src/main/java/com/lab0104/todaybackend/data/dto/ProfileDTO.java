package com.lab0104.todaybackend.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
