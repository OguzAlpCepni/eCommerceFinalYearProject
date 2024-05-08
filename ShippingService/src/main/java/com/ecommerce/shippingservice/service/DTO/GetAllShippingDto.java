package com.ecommerce.shippingservice.service.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllShippingDto {

    private int shippingId;

    private Long productId;

    private  String productTitle;

    private Double priceUnit;

    private int quantity;
}
