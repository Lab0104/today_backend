package com.lab0104.todaybackend.service;

import com.lab0104.todaybackend.data.dto.BannerDTO;
import org.springframework.stereotype.Service;


public interface BannerService {

    BannerDTO.Info findOne(long id);
    BannerDTO.Info findAll();
    BannerDTO.Info save(BannerDTO.Request request);
    BannerDTO.Info update(long id, BannerDTO.Request request) throws Exception;
    void delete(Long id) throws Exception;
}
/**
 *  1. 1개 조회
 *  2. 모두 조회
 *  3. save
 *  4. id값을 통한 update
 *  5. id값을 통한 삭제
 */



