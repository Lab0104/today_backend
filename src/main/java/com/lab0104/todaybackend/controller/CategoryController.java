package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.CategoryDTO;
import com.lab0104.todaybackend.service.CategoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/v1/category")
public class CategoryController {

    final private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "카테고리 단일 조회", notes = "해당 id의 카테고리 정보를 조회합니다.")
    @ApiImplicitParam(name = "id", value = "카테고리 생성 시 발급되는 id")
    public ResponseEntity<CategoryDTO.Info> getCategory(@PathVariable Long id){
        CategoryDTO.Info getCategoryDTO = categoryService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(getCategoryDTO);
    }

    @GetMapping(value = "/list/sub-category")
    @ApiOperation(value = "세부 카테고리 조회", notes = "해당 그룹의 세부 카테고리 정보를 리스트로 조회합니다.")
    public ResponseEntity<List<CategoryDTO.Info>> getSubCategoryListByGroup(int topCategoryId){
        List<CategoryDTO.Info> pageRequestDTO = categoryService.findSubCategoryListByGroup(topCategoryId);
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }

    @GetMapping(value = "/list/top-category/all")
    @ApiOperation(value = "대표 카테고리 조회", notes = "대표 카테고리를 리스트로 조회합니다.")
    public ResponseEntity<List<CategoryDTO.Info>> getTopCategoryList(){
        List<CategoryDTO.Info> pageRequestDTO = categoryService.findTopCategoryList();
        return ResponseEntity.status(HttpStatus.OK).body(pageRequestDTO);
    }

    @PostMapping(value = "/top")
    @ApiOperation(value = "대표 카테고리 생성", notes = "대표 카테고리를 생성합니다.")
    public ResponseEntity<CategoryDTO.Info> createTopCategory(@RequestBody CategoryDTO.topCategory categoryDTO) {
        CategoryDTO.Info createCategoryDTO = categoryService.saveTopCategory(categoryDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createCategoryDTO);
    }

    @PostMapping(value = "/sub")
    @ApiOperation(value = "세부 카테고리 생성", notes = "세부 카테고리를 생성합니다.")
     public ResponseEntity<CategoryDTO.Info> createSubCategory(@RequestBody CategoryDTO.Request categoryDTO) {
        CategoryDTO.Info createCategoryDTO = categoryService.saveSubCategory(categoryDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createCategoryDTO);
    }

    @PutMapping
    @ApiOperation(value = "카테고리 수정", notes = "카테고리 정보를 수정합니다.")
    @ApiImplicitParam(name = "id", value = "수정할 카테고리 id")
    public ResponseEntity<CategoryDTO.Info> changCategory(@PathVariable long id, @RequestBody CategoryDTO.Request categoryDTO) throws Exception{
        categoryService.update(id, categoryDTO);
        CategoryDTO.Info changeCategoryDTO = categoryService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(changeCategoryDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "카테고리 삭제", notes = "카테고리를 삭제합니다.")
    @ApiImplicitParam(name = "id", value = "삭제할 카테고리 id")
    public ResponseEntity<String> deleteCaterory(Long id) throws Exception {
        categoryService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("카테고리가 정상적으로 삭제되었습니다.");
    }
}
