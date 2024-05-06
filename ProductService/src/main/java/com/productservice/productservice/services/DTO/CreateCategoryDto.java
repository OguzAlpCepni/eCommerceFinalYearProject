package com.productservice.productservice.services.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class CreateCategoryDto {
    @NotNull
    private String categoryTitle;

}
