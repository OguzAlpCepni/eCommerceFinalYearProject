package com.productservice.productservice.services.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class CreateCategoryDto {
    private int categoryId;

    private String categoryTitle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ProductDto> productDtos;
}
