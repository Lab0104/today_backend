//package com.lab0104.todaybackend.data.dto;
//
//import com.lab0104.todaybackend.data.domain.mapping.HashtagMapping;
//import io.swagger.annotations.ApiModel;
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//public class HashtagDTO {
//    @Data
//    @ToString
//    @NoArgsConstructor(force = true)
//    @AllArgsConstructor
//    @Builder
//    @ApiModel("HashtagInfo")
//    public static class Info{
//        private long id;
//        private String tag;
//        private long hashtagMappingId;
//    }
//
//    @Data
//    @ToString
//    @NoArgsConstructor(force = true)
//    @AllArgsConstructor
//    @Builder
//    @ApiModel("HashtagRequest")
//    public static class Request{
//        private String tag;
//        private long hashtagMappingId;
//    }
//}
