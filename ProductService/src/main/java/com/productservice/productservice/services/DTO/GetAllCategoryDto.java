package com.productservice.productservice.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoryDto {
    private int categoryId;
    private String categoryTitle;
}
