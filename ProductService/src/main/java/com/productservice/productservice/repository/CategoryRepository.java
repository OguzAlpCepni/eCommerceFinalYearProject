package com.productservice.productservice.repository;

import com.productservice.productservice.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
        boolean existsBycategoryTitle(String categoryTitle);
}
