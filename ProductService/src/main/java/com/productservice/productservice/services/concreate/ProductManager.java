package com.productservice.productservice.services.concreate;

import com.productservice.productservice.core.mapper.ModelMapperService;
import com.productservice.productservice.entity.ProductEntity;
import com.productservice.productservice.repository.ProductRepository;
import com.productservice.productservice.services.DTO.CreateProductDto;
import com.productservice.productservice.services.DTO.ProductDto;
import com.productservice.productservice.services.DTO.UpdateProductDto;
import com.productservice.productservice.services.abstracts.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<ProductDto> findAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDto> productDtos = productEntities.stream().map(productEntity -> this.modelMapperService.forResponse().map(productEntity,ProductDto.class)).collect(Collectors.toList());
        return null;
    }

    @Override
    public ProductDto findById(int id) {
        return null;
    }

    @Override
    public void add(CreateProductDto createProductDto) {

    }

    @Override
    public void update(UpdateProductDto UpdateProductDto) {

    }

    @Override
    public void delete(int id) {

    }
}
