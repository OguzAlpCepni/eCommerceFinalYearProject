package com.productservice.productservice.services.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateProductDto {
    private Long productId;
    @NotNull
    @Size(min = 1,max=50)
    private String productTitle;

    private String imageUrl;
    @NotNull
    @Size(max=50)
    private double priceUnit;
    @NotNull
    @Size(min = 1,max=50)
    @NotEmpty
    private int quantity;
    @JsonProperty("category")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CategoryDto categoryDto;
}
