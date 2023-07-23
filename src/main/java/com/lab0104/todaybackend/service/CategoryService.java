package com.lab0104.todaybackend.service;

import com.lab0104.todaybackend.data.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO.Info findOne(Long id);

    CategoryDTO.Info saveSubCategory(CategoryDTO.Request categoryDTO);

    CategoryDTO.Info saveTopCategory(CategoryDTO.topCategory categoryDTO);

    CategoryDTO.Info update(Long id, CategoryDTO.Request categoryDTO) throws  Exception;

    void delete(Long id) throws Exception;

    //list
    List<CategoryDTO.Info> findSubCategoryListByGroup(long topCategoryId);
    List<CategoryDTO.Info> findTopCategoryList();

}
