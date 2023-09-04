package com.lab0104.todaybackend.service.impl;

import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.data.repository.MeetRepository;
import com.lab0104.todaybackend.data.repository.UserRepository;
import com.lab0104.todaybackend.service.EntityAndDtoConversionService;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl {

    final private MeetRepository meetRepository;
    final private UserRepository userRepository;
    final private EntityAndDtoConversionService dataConversion;

    public BannerServiceImpl(MeetRepository meetRepository, UserRepository userRepository, EntityAndDtoConversionService dataConversion) {
        this.meetRepository = meetRepository;
        this.userRepository = userRepository;
        this.dataConversion = dataConversion;
    }

//    @Override
//    public MeetDTO.Info findOne(Long id) {
//
//    }
}
