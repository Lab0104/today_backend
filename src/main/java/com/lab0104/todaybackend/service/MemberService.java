package com.lab0104.todaybackend.service;

import com.lab0104.todaybackend.data.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    List<MemberDTO.Info> findByMeet(long meetId);

    MemberDTO.Info save(MemberDTO.Request memberDTO);

    void delete(Long id) throws Exception;

}
