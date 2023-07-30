package com.lab0104.todaybackend.service;

import com.lab0104.todaybackend.data.dto.MeetDTO;

import java.util.List;

public interface MeetService {
    MeetDTO.Info findOne(Long id);
    MeetDTO.Info save(MeetDTO.Request meetDTO);
    MeetDTO.Info update(Long id, MeetDTO.Request meetDTO) throws  Exception;
    void delete(Long id) throws Exception;

    //list
    List<MeetDTO.Info> findList(int number, int size);
    List<MeetDTO.Info> findListByCategory(int number, int size, long categoryId);
    List<MeetDTO.Info> findListByUser(int number, int size, long userId);

    //Card List
    List<MeetDTO.MainCard> findListForMainCard(int number, int size);
    List<MeetDTO.MainCard> findMainCardListByCategory(int number, int size, long categoryId);

    List<MeetDTO.MapCard> findListForMapCard(int number, int size, String Keyword);
}