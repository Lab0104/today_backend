//package com.lab0104.todaybackend.data.dto;
//
//import io.swagger.annotations.ApiModel;
//import lombok.*;
//
//public class InterestsDTO {
//    @Data
//    @ToString
//    @NoArgsConstructor(force = true)
//    @AllArgsConstructor
//    @Builder
//    @ApiModel("InterestsInfo")
//    public static class Info {
//        private long id;
//        private long categoryId;
//        private long userId;
//    }
//
//    @Data
//    @ToString
//    @NoArgsConstructor(force = true)
//    @AllArgsConstructor
//    @Builder
//    @ApiModel("InterestsRequest")
//    public static class Request {
//        private long categoryId;
//        private long userId;
//    }
//
//}