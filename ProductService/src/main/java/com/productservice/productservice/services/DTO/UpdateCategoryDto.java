package com.productservice.productservice.services.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UpdateCategoryDto {
    private int categoryId;
    @NotNull
    private String categoryTitle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ProductDto> productDtos;
}
