package com.productservice.productservice.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private String productTitle;

    private String imageUrl;

    private double priceUnit;

    private int quantity;

    private CategoryDto categoryDto;
}
