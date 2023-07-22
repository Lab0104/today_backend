package com.lab0104.todaybackend.service.impl;

import com.lab0104.todaybackend.data.domain.Category;
import com.lab0104.todaybackend.data.domain.User;
import com.lab0104.todaybackend.data.dto.CategoryDTO;
import com.lab0104.todaybackend.data.dto.UserDTO;
import com.lab0104.todaybackend.data.repository.CategoryRepository;
import com.lab0104.todaybackend.service.CategoryService;
import com.lab0104.todaybackend.service.EntityAndDtoConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    final private CategoryRepository categoryRepository;
    final private EntityAndDtoConversionService dataConversion;

    public CategoryServiceImpl(CategoryRepository categoryRepository, EntityAndDtoConversionService dataConversion) {
        this.categoryRepository = categoryRepository;
        this.dataConversion = dataConversion;
    }

    @Override
    public CategoryDTO.Info findOne(Long id) {
        Category category = categoryRepository.getById(id);
        CategoryDTO.Info findCategoryDTO = dataConversion.categoryEntityToDTO(category);

        return findCategoryDTO;
    }
    @Override
    public CategoryDTO.Info saveTopCategory(CategoryDTO.topCategory categoryDTO){
        Category category = Category.builder()
                .name(categoryDTO.getName())
                .imageUrl(categoryDTO.getImageUrl())
                .categoryGroup(null)
                .build();
        categoryRepository.save(category);

        return dataConversion.categoryEntityToDTO(category);
    }

    @Override
    public CategoryDTO.Info saveSubCategory(CategoryDTO.Request categoryDTO){
        Category category = categoryRepository.save(dataConversion.categoryDtoToEntity(categoryDTO));
        CategoryDTO.Info saveCategoryDTO = dataConversion.categoryEntityToDTO(category);
        return saveCategoryDTO;
    }

    public CategoryDTO.Info update(Long id, CategoryDTO.Request categoryDTO) throws Exception{
        Category category = dataConversion.categoryDtoToEntity(categoryDTO);
        category.setIdForCategoryUpdate(id);

        CategoryDTO.Info updateCategoryDTO = dataConversion.categoryEntityToDTO(categoryRepository.save(category));

        return updateCategoryDTO;
    }

    public void delete(Long id) throws Exception{
        categoryRepository.deleteById(id);
    }

}