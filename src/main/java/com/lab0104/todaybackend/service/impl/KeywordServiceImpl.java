package com.lab0104.todaybackend.service.impl;

import com.lab0104.todaybackend.data.domain.Keyword;
import com.lab0104.todaybackend.data.dto.KeywordDTO;
import com.lab0104.todaybackend.data.repository.KeywordRepository;
import com.lab0104.todaybackend.service.EntityAndDtoConversionService;
import com.lab0104.todaybackend.service.KeywordService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KeywordServiceImpl implements KeywordService {

    final private KeywordRepository keywordRepository;
    final private EntityAndDtoConversionService dataConversion;

    public KeywordServiceImpl(KeywordRepository keywordRepository, EntityAndDtoConversionService dataConversion) {
        this.keywordRepository = keywordRepository;
        this.dataConversion = dataConversion;
    }

    @Override
    public KeywordDTO.Info findOne(Long id) {
        Keyword keyword = keywordRepository.getById(id);


        return null;
    }

    @Override
    public KeywordDTO.Info findAll() {
//        List<Keyword> all = keywordRepository.findAll();

        return null;
    }

    @Override
    public KeywordDTO.Info save(KeywordDTO.Request keywordDTO) {
        return null;
    }

    @Override
    public KeywordDTO.Info update(Long id, KeywordDTO.Request keywordDTO) {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
