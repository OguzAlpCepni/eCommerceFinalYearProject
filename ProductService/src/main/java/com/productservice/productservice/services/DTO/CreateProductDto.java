package com.productservice.productservice.services.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {
    @NotNull
    @Size(min = 1,max=50)
    private String productTitle;
    @NotNull
    private String imageUrl;

    @Positive
    private double priceUnit;

    @Positive
    private int quantity;

    private int categoryId;
}
