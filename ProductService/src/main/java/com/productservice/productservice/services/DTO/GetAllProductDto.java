package com.productservice.productservice.services.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductDto {
    private Long productId;
    private String productTitle;

    private String imageUrl;

    private double priceUnit;

    private int quantity;
    private String categoryTitle;
}
