package com.lab0104.todaybackend.data.dto;

import com.lab0104.todaybackend.data.domain.Meet;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.data.domain.Page;

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

        //base entity
        private LocalDateTime createdAt;
        private LocalDateTime updateAT;
    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("MeetTest")
    public static class test{
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


    public static Info entityToDTOList(Meet meet){
        return Info.builder()
                .id(meet.getId())
                .title(meet.getTitle())
                .subTitle(meet.getSubTitle())
                .content(meet.getContent())
                .date(meet.getDate())
                .deadline(meet.getDeadline())
                .maximum(meet.getMaximum())
                .addressLatitude(meet.getAddressLatitude())
                .addressLongitude(meet.getAddressLongitude())
                .category(meet.getCategory().getId())
                .user(meet.getUser().getId())
                .build();

    }




}
