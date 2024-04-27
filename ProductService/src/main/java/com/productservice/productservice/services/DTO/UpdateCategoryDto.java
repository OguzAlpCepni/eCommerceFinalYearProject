package com.productservice.productservice.services.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class UpdateCategoryDto {
    private int categoryId;
    private String categoryTitle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ProductDto> productDtos;
}
