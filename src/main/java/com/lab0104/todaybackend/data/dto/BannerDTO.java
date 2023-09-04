package com.lab0104.todaybackend.data.dto;

import com.lab0104.todaybackend.data.domain.Meet;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class BannerDTO {

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("BannerInfo")
    public static class Info {

        private long id;
        private LocalDateTime display_period;
        private String title;
        private String contents;
        private Long image_url;
        private String userName;
        private String meetName;
    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("BannerRequest")
    public static class Request {
        private LocalDateTime display_period;
        private String title;
        private String contents;
        private Long image_url;
        private long user;
        private long meet;
    }

}
