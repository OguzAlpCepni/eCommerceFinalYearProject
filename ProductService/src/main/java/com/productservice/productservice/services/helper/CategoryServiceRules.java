package com.productservice.productservice.services.helper;

import com.productservice.productservice.core.exceptions.BusinessException;
import com.productservice.productservice.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceRules {
    private CategoryRepository categoryRepository;

    public void checkIfProductExists(String categoryTitle){
        if(this.categoryRepository.existsBycategoryTitle(categoryTitle)){
            throw new BusinessException("category name already exists. ");
        }

    }
}
