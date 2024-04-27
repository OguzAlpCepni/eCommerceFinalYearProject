package com.productservice.productservice.services.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {
    private Long productId;
    private String productTitle;

    private String imageUrl;

    private double priceUnit;

    private int quantity;
    @JsonProperty("category")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CategoryDto categoryDto;
}
