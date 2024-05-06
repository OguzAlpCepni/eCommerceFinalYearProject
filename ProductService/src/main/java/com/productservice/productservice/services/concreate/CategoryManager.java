package com.productservice.productservice.services.concreate;

import com.productservice.productservice.core.mapper.ModelMapperService;
import com.productservice.productservice.entity.CategoryEntity;
import com.productservice.productservice.repository.CategoryRepository;
import com.productservice.productservice.services.DTO.CategoryDto;
import com.productservice.productservice.services.DTO.CreateCategoryDto;
import com.productservice.productservice.services.DTO.GetAllCategoryDto;
import com.productservice.productservice.services.DTO.UpdateCategoryDto;
import com.productservice.productservice.services.abstracts.CategoryService;
import com.productservice.productservice.services.helper.CategoryServiceRules;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@Slf4j
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    private CategoryServiceRules categoryServiceRules;

    @Override
    public List<GetAllCategoryDto> findAll() {
        log.info("*** CategoryDto List, service; fetch all categorys *");
        List<CategoryEntity> categoryEntities = this.categoryRepository.findAll();
        List<GetAllCategoryDto> getAllCategoryDto = categoryEntities.stream().map(categoryEntity -> this.modelMapperService.forResponse().map(categoryEntity,GetAllCategoryDto.class)).collect(Collectors.toList());
        return getAllCategoryDto;
    }

    @Override
    public CategoryDto findById(int id) {
        log.info("*** CategoryDto, service; fetch category by id *");
        CategoryEntity categoryEntity = this.categoryRepository.findById(id).orElseThrow();
        CategoryDto categoryDto = this.modelMapperService.forResponse().map(categoryEntity,CategoryDto.class);

        return categoryDto;
    }


    @Override
    public void add(CreateCategoryDto createCategoryDto) {
        log.info("*** CreateCategoryDto, service; save category *");
        this.categoryServiceRules.checkIfProductExists(createCategoryDto.getCategoryTitle());
        CategoryEntity categoryEntity = this.modelMapperService.forRequest().map(createCategoryDto,CategoryEntity.class);
        this.categoryRepository.save(categoryEntity);

    }

    @Override
    public void update(UpdateCategoryDto updateCreateDto) {
        log.info("*** updateCategoryDto, service; update category *");
        CategoryEntity categoryEntity = this.modelMapperService.forRequest().map(updateCreateDto,CategoryEntity.class);
        this.categoryRepository.save(categoryEntity);
    }

    @Override
    public void delete(int id) {
        log.info("*** Void, service; delete category by id *");
        this.categoryRepository.deleteById(id);
    }

    @Override
    public void update(int categoryId, UpdateCategoryDto updateCreateDto) {
        log.info("*** CategoryDto, service; update category with categoryId *");
        CategoryEntity categoryEntity = this.modelMapperService.forRequest().map(updateCreateDto,CategoryEntity.class);
        this.categoryRepository.deleteById(categoryId);
        this.categoryRepository.save(categoryEntity);
    }
}
