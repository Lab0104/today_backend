package com.lab0104.todaybackend.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDateTime;

public class MeetDTO {

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("MeetInfo")
    public static class Info {

        private long id;
        private String title;
        private String subTitle;
        private String content;
        private LocalDateTime date;
        private LocalDateTime deadline;
        private int maximum;
        private String address;
        private double addressLatitude;
        private double addressLongitude;
        private long category;
        private long user;

        //base entity
        private LocalDateTime createdAt;
        private LocalDateTime updateAT;

    }
    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("MeetRequest")
    public static class Request{
        private String title;
        private String subTitle;
        private String content;
        private LocalDateTime date;
        private LocalDateTime deadline;
        private int maximum;
        private String address;
        private double addressLatitude;
        private double addressLongitude;
        private long category;
        private long user;
    }
}
