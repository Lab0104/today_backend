package com.lab0104.todaybackend.service;

import com.lab0104.todaybackend.data.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO.Info findOne(Long id);

    CategoryDTO.Info save(CategoryDTO.Request categoryDTO);

    CategoryDTO.Info update(Long id, CategoryDTO.Request categoryDTO) throws  Exception;

    void delete(Long id) throws Exception;
}
