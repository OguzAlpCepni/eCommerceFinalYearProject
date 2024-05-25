package com.productservice.productservice.services.abstracts;


import com.productservice.productservice.services.DTO.CreateProductDto;
import com.productservice.productservice.services.DTO.GetAllProductDto;
import com.productservice.productservice.services.DTO.ProductDto;
import com.productservice.productservice.services.DTO.UpdateProductDto;

import java.util.List;

public interface ProductService {
     List<GetAllProductDto> findAll();
     ProductDto findById(Long id);
     void add(CreateProductDto createProductDto);
     void update(UpdateProductDto updateProductDto);
     void delete(Long id);
     void updateById(Long productId,UpdateProductDto updateProductDto);
     ProductDto findByItemSku(long id);
     void updateToSku(Long itemku,UpdateProductDto updateProductDto);

}
