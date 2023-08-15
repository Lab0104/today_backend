package com.lab0104.todaybackend.service;

import com.lab0104.todaybackend.data.domain.Keyword;
import com.lab0104.todaybackend.data.dto.KeywordDTO;

public interface KeywordService {

    KeywordDTO.Info findOne(Long id);

    KeywordDTO.Info save(KeywordDTO.Request keywordDTO);

    KeywordDTO.Info update(Long id, KeywordDTO.Request keywordDTO);

    void delete(Long id) throws Exception;

    /**
     * Info 에 값들을 저장하고 DtoToEntity를 통해서 값들을 통신한다
     * 추후에, 값들을 리턴해줄땐 Info값이 아닌 Request를 통해서 내보낸다.
     *  그리고 DAO에서 메소드를 처리하지 않는 이유는
     *  1. 파일의 결합도를 낮춘다.
     *  2. 각 개발단이 가지는 역할을 확실하게 나눠서 유지보수하고자 함.
     *
     */
}
