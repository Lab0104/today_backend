package com.lab0104.todaybackend.service.impl;

import com.lab0104.todaybackend.data.domain.Category;
import com.lab0104.todaybackend.data.dto.CategoryDTO;
import com.lab0104.todaybackend.data.repository.CategoryRepository;
import com.lab0104.todaybackend.service.CategoryService;
import com.lab0104.todaybackend.service.EntityAndDtoConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public List<CategoryDTO.Info> findSubCategoryListByGroup(long topCategoryId){
        Category topategory = categoryRepository.getById(topCategoryId);

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, Math.toIntExact(categoryRepository.countByDepth(2)), sort);
        Page<CategoryDTO.Info> response = categoryRepository.findByCategoryGroup(topategory, pageable).map(dataConversion::categoryEntityToDTO);

        List<CategoryDTO.Info> pageRequestDTO = new ArrayList<>();
        for(CategoryDTO.Info i : response){
            pageRequestDTO.add(i);
        }
        return pageRequestDTO;
    }

    public List<CategoryDTO.Info> findTopCategoryList(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, Math.toIntExact(categoryRepository.countByDepth(1)), sort);
        Page<CategoryDTO.Info> response = categoryRepository.findByDepth(1, pageable).map(dataConversion::categoryEntityToDTO);

        List<CategoryDTO.Info> pageRequestDTO = new ArrayList<>();
        for(CategoryDTO.Info i : response){
            pageRequestDTO.add(i);
        }
        return pageRequestDTO;
    }

}