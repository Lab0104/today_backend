package com.lab0104.todaybackend.service.impl;

import com.lab0104.todaybackend.data.domain.Meet;
import com.lab0104.todaybackend.data.domain.Member;
import com.lab0104.todaybackend.data.dto.MemberDTO;
import com.lab0104.todaybackend.data.repository.MeetRepository;
import com.lab0104.todaybackend.data.repository.MemberRepository;
import com.lab0104.todaybackend.data.repository.UserRepository;
import com.lab0104.todaybackend.service.EntityAndDtoConversionService;
import com.lab0104.todaybackend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    final private MeetRepository meetRepository;
    final private MemberRepository memberRepository;
    final private EntityAndDtoConversionService dataConversion;

    public MemberServiceImpl(MeetRepository meetRepository, MemberRepository memberRepository, EntityAndDtoConversionService dataConversion) {
        this.meetRepository = meetRepository;
        this.memberRepository = memberRepository;
        this.dataConversion = dataConversion;
    }


    @Override
    public List<MemberDTO.Info> findByMeet(long meetId){
        Meet meet = meetRepository.getById(meetId);

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageableWithSort = PageRequest.of(1, 4, sort);
        Page<MemberDTO.Info> response = memberRepository.findByMeet(meet, pageableWithSort).map(MemberDTO::MemberEntityToDTOList);

        List<MemberDTO.Info> pageRequestDTO = new ArrayList<>();
        for (MemberDTO.Info i : response){
            pageRequestDTO.add(i);
        }
        return pageRequestDTO;
    }

    @Override
    public MemberDTO.Info save(MemberDTO.Request memberDTO){
        Member member = memberRepository.save(dataConversion.memberDtoToEntity(memberDTO));
        MemberDTO.Info saveMeetDTO = dataConversion.memberEntityToDTO(member);
        return saveMeetDTO;
    }

    @Override
    public void delete(Long id) throws Exception{
        memberRepository.deleteById(id);
    }

}
