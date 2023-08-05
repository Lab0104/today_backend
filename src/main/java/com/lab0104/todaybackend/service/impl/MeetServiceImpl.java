package com.lab0104.todaybackend.service.impl;

import com.lab0104.todaybackend.data.domain.Meet;
import com.lab0104.todaybackend.data.domain.User;
import com.lab0104.todaybackend.data.domain.Category;
import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.data.repository.CategoryRepository;
import com.lab0104.todaybackend.data.repository.MeetRepository;
import com.lab0104.todaybackend.data.repository.UserRepository;
import com.lab0104.todaybackend.service.EntityAndDtoConversionService;
import com.lab0104.todaybackend.service.MeetService;
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
public class MeetServiceImpl implements MeetService {
    final private MeetRepository meetRepository;
    final private UserRepository userRepository;
    final private CategoryRepository categoryRepository;
    final private EntityAndDtoConversionService dataConversion;

    public MeetServiceImpl(MeetRepository meetRepository, UserRepository userRepository, CategoryRepository categoryRepository, EntityAndDtoConversionService dataConversion){
        this.meetRepository = meetRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.dataConversion = dataConversion;
    }

    @Override
    public MeetDTO.Info findOne(Long id) {
        Meet meet = meetRepository.getById(id);
        MeetDTO.Info findMeetDTO = dataConversion.meetEntityToDTO(meet);

        return findMeetDTO;
    }

    @Override
    public MeetDTO.Info save(MeetDTO.Request meetDTO){
        Meet meet = meetRepository.save(dataConversion.meetDtoToEntity(meetDTO));
        MeetDTO.Info saveMeetDTO = dataConversion.meetEntityToDTO(meet);
        return saveMeetDTO;
    }

    public MeetDTO.Info update(Long id, MeetDTO.Request meetDTO) throws Exception{
        Meet meet = dataConversion.meetDtoToEntity(meetDTO);
        meet.setMeetIdForUpdate(id);

        MeetDTO.Info updateMeetDTO = dataConversion.meetEntityToDTO(meetRepository.save(meet));

        return updateMeetDTO;
    }

    public void delete(Long id) throws Exception{
        meetRepository.deleteById(id);
    }


    @Override
    public List<MeetDTO.Info> findList(int number, int size){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageableWithSort = PageRequest.of(number, size, sort);
        Page<MeetDTO.Info> response = meetRepository.findAll(pageableWithSort).map(dataConversion::meetEntityToDTO);

        List<MeetDTO.Info> pageRequestDTO = new ArrayList<>();
        for (MeetDTO.Info i : response){
            pageRequestDTO.add(i);
        }
        return pageRequestDTO;
    }

    @Override
    public List<MeetDTO.Info> findListByCategory(int number, int size, long categoryId){
        Category category = categoryRepository.getById(categoryId);

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageableWithSort = PageRequest.of(number, size, sort);
        Page<MeetDTO.Info> response = meetRepository.findBySubCategory(category, pageableWithSort).map(dataConversion::meetEntityToDTO);

        List<MeetDTO.Info> pageRequestDTO = new ArrayList<>();
        for (MeetDTO.Info i : response){
            pageRequestDTO.add(i);
        }
        return pageRequestDTO;
    }

    @Override
    public List<MeetDTO.Info> findListByUser(int number, int size, long userId){
        User user = userRepository.getById(userId);

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageableWithSort = PageRequest.of(number, size, sort);
        Page<MeetDTO.Info> response = meetRepository.findByUser(user, pageableWithSort).map(dataConversion::meetEntityToDTO);

        List<MeetDTO.Info> pageRequestDTO = new ArrayList<>();
        for (MeetDTO.Info i : response){
            pageRequestDTO.add(i);
        }
        return pageRequestDTO;
    }

    @Override
    public List<MeetDTO.MainCard> findListForMainCard(int number, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageableWithSort = PageRequest.of(number, size, sort);
        Page<MeetDTO.MainCard> response = meetRepository.findAll(pageableWithSort).map(dataConversion::meetMainCardEntityToDTO);

        List<MeetDTO.MainCard> pageRequestDTO = new ArrayList<>();
        for (MeetDTO.MainCard i : response){
            pageRequestDTO.add(i);
        }
        return pageRequestDTO;
    }

    @Override
    public List<MeetDTO.MainCard> findMainCardListByCategory(int number, int size, long categoryId) {
        Category category = categoryRepository.getById(categoryId);

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageableWithSort = PageRequest.of(number, size, sort);
        Page<MeetDTO.MainCard> response = meetRepository.findBySubCategory(category, pageableWithSort).map(dataConversion::meetMainCardEntityToDTO);

        List<MeetDTO.MainCard> pageRequestDTO = new ArrayList<>();
        for (MeetDTO.MainCard i : response){
            pageRequestDTO.add(i);
        }
        return pageRequestDTO;
    }

    @Override
    public List<MeetDTO.MapCard> findListForMapCard(int number, int size, String keyword) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageableWithSort = PageRequest.of(number, size, sort);
        Page<MeetDTO.MapCard> response = meetRepository.findByTitleContaining(keyword, pageableWithSort).map(dataConversion::meetMapCardEntityToDTO);

        List<MeetDTO.MapCard> pageRequestDTO = new ArrayList<>();
        for (MeetDTO.MapCard i : response){
            pageRequestDTO.add(i);
        }
        return pageRequestDTO;
    }
}
