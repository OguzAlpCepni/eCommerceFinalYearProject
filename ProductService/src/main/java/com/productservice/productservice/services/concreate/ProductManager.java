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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;
    private ProductServiceRules productServiceRules;
    @Override
    public List<ProductDto> findAll() {
        log.info("*** ProductDto List, service; fetch all products *");
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDto> productDtos = productEntities.stream().map(productEntity -> this.modelMapperService.forResponse().map(productEntity,ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ProductDto findById(Long id) {
        log.info("*** ProductDto, service; fetch product by id *");
        ProductEntity productEntity = this.productRepository.findById(id).orElseThrow();
        ProductDto productDto= this.modelMapperService.forResponse().map(productEntity,ProductDto.class);
        return productDto;
    }

    @Override
    public void add(CreateProductDto createProductDto) {
        log.info("*** ProductDto, service; save product *");
        productServiceRules.checkIfProductExists(createProductDto.getProductTitle());
        ProductEntity productEntity = this.modelMapperService.forRequest().map(createProductDto,ProductEntity.class);
        this.productRepository.save(productEntity);
    }

    @Override
    public void update(UpdateProductDto updateProductDto) {
        log.info("*** ProductDto, service; update product *");
        ProductEntity productEntity = this.modelMapperService.forRequest().map(updateProductDto,ProductEntity.class);
        this.productRepository.save(productEntity);
    }

    @Override
    public void delete(Long id) {

        log.info("*** Void, service; delete product by id *");this.productRepository.deleteById(id);
    }


    @Override
    public void updateById(Long productId, UpdateProductDto updateProductDto) {
        log.info("*** ProductDto, service; update product with productId *");
        ProductEntity productEntitynNew = this.modelMapperService.forRequest().map(updateProductDto,ProductEntity.class);
        this.productRepository.deleteById(productId);
        this.productRepository.save(productEntitynNew);
    }
}