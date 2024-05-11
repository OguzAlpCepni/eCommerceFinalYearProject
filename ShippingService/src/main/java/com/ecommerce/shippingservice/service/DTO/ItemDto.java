package com.ecommerce.shippingservice.service.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Long productId;
    private String productTitle;

    private String imageUrl;
    private Long itemsku;
    private BigDecimal priceUnit;

    private int quantity;


}
