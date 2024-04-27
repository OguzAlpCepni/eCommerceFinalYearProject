package com.productservice.productservice.services.abstracts;



import com.productservice.productservice.services.DTO.CategoryDto;
import com.productservice.productservice.services.DTO.CreateCategoryDto;
import com.productservice.productservice.services.DTO.UpdateCategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(int id);
    void add(CreateCategoryDto createCategoryDto);
    void update(UpdateCategoryDto UpdateCreateDto);
    void delete(int id);
}
