package com.lab0104.todaybackend.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDateTime;

public class CategoryDTO {

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("CategoryInfo")
    public static class Info{
        private Long id;
        private String name;
        private Integer depth;
        private String imageUrl;
        private Long categoryGroup; //자기참조

        //base entity
        private LocalDateTime createdAt;
        private LocalDateTime updateAT;
    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("CategoryRequest")
    public static class Request{
        private String name;
        private String imageUrl;
        private Long categoryGroup;

        //base entity
        private LocalDateTime createdAt;
        private LocalDateTime updateAT;
    }


    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("TopCategoryRequest")
    public static class TopCategoryRequest{
        private String name;
        private String imageUrl;

        //base entity
        private LocalDateTime createdAt;
        private LocalDateTime updateAT;
    }

}
