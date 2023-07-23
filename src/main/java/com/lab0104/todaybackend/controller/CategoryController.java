package com.lab0104.todaybackend.controller;


import com.lab0104.todaybackend.data.domain.Category;
import com.lab0104.todaybackend.data.dto.CategoryDTO;
import com.lab0104.todaybackend.data.dto.MeetDTO;
import com.lab0104.todaybackend.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/category")
public class CategoryController {

    final private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping(value = "category")
    @ApiOperation(value = "")
     public ResponseEntity<CategoryDTO.Info> createCategory(@RequestBody CategoryDTO.Request categoryDTO) {
        CategoryDTO.Info createCategoryDTO = categoryService.save(categoryDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createCategoryDTO);
    }

    @GetMapping
    @ApiOperation(value = "")
    public ResponseEntity<CategoryDTO.Info> getCategory(Long id){
        CategoryDTO.Info getCategoryDTO = categoryService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(getCategoryDTO);
    }


    @PutMapping
    @ApiOperation(value ="")
    public ResponseEntity<CategoryDTO.Info>changMeet(Category id, @RequestBody CategoryDTO.Request categoryDTO) throws Exception{
        categoryService.update(id.getId(), categoryDTO);
        CategoryDTO.Info changeCategoryDTO = categoryService.findOne(id.getId());

        return ResponseEntity.status(HttpStatus.OK).body(changeCategoryDTO);
    }


    @DeleteMapping
    @ApiOperation(value = "")
    public ResponseEntity<String> deleteCaterory(Long id) throws Exception {
        categoryService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
