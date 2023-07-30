package com.lab0104.todaybackend.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
        private String topCategory;
        private String subCategory;
        private String user;

        //base entity
        private LocalDateTime createdAt;
        private LocalDateTime updateAt;

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
        private long subCategoryId;
        private long userId;
    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("MeetCardForMain")
    public static class MainCard{
        private String title;
        private LocalDateTime date;
        private LocalDateTime deadline;
        private String address;
        private String topCategory;
        private String subCategory;

        //set
        @ApiModelProperty(example = "D-Day")
        private String limit;
        @ApiModelProperty(example = "모집 중, 모집 마감")
        private String status;
        @ApiModelProperty(example = "좋아요 여부")
        private Boolean likesCheck;

    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("MeetCardForMap")
    public static class MapCard{
        private String title;
        private LocalDateTime date;
        private LocalDateTime deadline;
        private String address;
        private String topCategory;
        private String subCategory;

        //set
        @ApiModelProperty(example = "모집 중, 모집 마감")
        private String status;
        @ApiModelProperty(example = "좋아요 여부")
        private Boolean likesCheck;
        @ApiModelProperty(example = "업로드 시점부터 지난 시간(분)")
        private String uploadAt;
    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("MeetCardForPost")
    public static class PostCard{
        private String title;
        private LocalDateTime date;
        private LocalDateTime deadline;
        private String address;
        private int maximum;
        private String topCategory;
        private String subCategory;
        private String userImageUrl;

        //set
        @ApiModelProperty(example = "D-Day")
        private long limit;
        @ApiModelProperty(example = "모집 중, 모집 마감")
        private String status;
        @ApiModelProperty(example = "지원인원")
        private Long currentMemberCount;
        @ApiModelProperty(example = "좋아요 여부")
        private Boolean likesCheck;
        @ApiModelProperty(example = "업로드 시점부터 지난 시간(분)")
        private long uploadAt;
    }
}
