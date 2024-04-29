package com.productservice.productservice.services.helper;

import com.productservice.productservice.core.exceptions.BusinessException;
import com.productservice.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceRules {
    private ProductRepository productRepository;

    public void checkIfProductExists(String productName){
        if(this.productRepository.existsByName(productName)){
            throw new BusinessException("Product name already exists. ");
        }

    }


}
