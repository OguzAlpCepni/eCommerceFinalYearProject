package com.productservice.productservice.Controller;

import com.productservice.productservice.services.DTO.CategoryDto;
import com.productservice.productservice.services.DTO.CreateCategoryDto;
import com.productservice.productservice.services.DTO.GetAllCategoryDto;
import com.productservice.productservice.services.DTO.UpdateCategoryDto;
import com.productservice.productservice.services.abstracts.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private  CategoryService categoryService;

    @GetMapping
    public ResponseEntity findAllCategory(){
        List<GetAllCategoryDto> getAllCategoryDto = this.categoryService.findAll();
        return ResponseEntity.ok(getAllCategoryDto);
    }
    @GetMapping("/{categoryid}")
    public ResponseEntity findById(@PathVariable("categoryid") int id){

        CategoryDto categoryDto = this.categoryService.findById(id);
        return ResponseEntity.ok(categoryDto);
    }
    @PostMapping
    public ResponseEntity addCategory(@RequestBody @Valid CreateCategoryDto createCategoryDto){
        this.categoryService.add(createCategoryDto);
        return ResponseEntity.ok("category added system");
    }
    @PutMapping
    public ResponseEntity update(@RequestBody @Valid UpdateCategoryDto updateCategoryDto){
        this.categoryService.update(updateCategoryDto);
        return ResponseEntity.ok("update category");
    }

    @PutMapping("/{categoryid}")
    public ResponseEntity update(@PathVariable("categoryid") int id,@RequestBody @Valid UpdateCategoryDto updateCategoryDto){
        this.categoryService.update(id,updateCategoryDto);
        return ResponseEntity.ok("update category by id");
    }
    @DeleteMapping("/{categoryid}")
    public ResponseEntity delete(@PathVariable("categoryid") int id){
        this.categoryService.delete(id);
        return ResponseEntity.ok("category deleted");
    }
}



