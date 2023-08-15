package com.lab0104.todaybackend.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class KeywordDTO {

    /**
     * Builder 와 Noargs(기본생성자)를 사용하려면, Allargs(모든 field data)를
     * 참조하고 있는 값을 사용해줘야 한다. 안그러면, 예외로 인한 컴파일 에러가 발생한다.
     */
    @Data
    @NoArgsConstructor(force = true) // final 변수가 있을 경우, 강제로 0/false/null로
    // 초기화 하는데, 현재 클래스에 final 선언한 변수가 있나?
    @AllArgsConstructor
    @Builder
    @ApiModel("KeywordInfo")
    public static class Info {
        private long id;
        private String keyword;
    }

    @Data
    @NoArgsConstructor(force = true)
    @AllArgsConstructor
    @Builder
    @ApiModel("KeywordRequest")
    public static class Request {
        private String keyword;
    }
    /**
     * Info 는 요청에 대한 내보내서는 안되는 PK 값을 소유함
     * Request는 요청에 대해서 내보내서는 안되는 값들을 가리고 내보냄
     */
}
