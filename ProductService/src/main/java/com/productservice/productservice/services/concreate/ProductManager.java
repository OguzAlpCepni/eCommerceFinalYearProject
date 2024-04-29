package com.productservice.productservice.services.concreate;

import com.productservice.productservice.core.mapper.ModelMapperService;
import com.productservice.productservice.entity.ProductEntity;
import com.productservice.productservice.repository.ProductRepository;
import com.productservice.productservice.services.DTO.CreateProductDto;
import com.productservice.productservice.services.DTO.ProductDto;
import com.productservice.productservice.services.DTO.UpdateProductDto;
import com.productservice.productservice.services.abstracts.ProductService;
import com.productservice.productservice.services.helper.ProductServiceRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;
    private ProductServiceRules productServiceRules;
    @Override
    public List<ProductDto> findAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDto> productDtos = productEntities.stream().map(productEntity -> this.modelMapperService.forResponse().map(productEntity,ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ProductDto findById(Long id) {
        ProductEntity productEntity = this.productRepository.findById(id).orElseThrow();
        ProductDto productDto= this.modelMapperService.forResponse().map(productEntity,ProductDto.class);
        return productDto;
    }

    @Override
    public void add(CreateProductDto createProductDto) {
        productServiceRules.checkIfProductExists(createProductDto.getProductTitle());
        ProductEntity productEntity = this.modelMapperService.forRequest().map(createProductDto,ProductEntity.class);
        this.productRepository.save(productEntity);
    }

    @Override
    public void update(UpdateProductDto updateProductDto) {
        ProductEntity productEntity = this.modelMapperService.forRequest().map(updateProductDto,ProductEntity.class);
        this.productRepository.save(productEntity);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
