package com.productservice.productservice.repository;

import com.productservice.productservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    boolean existsByproductTitle(String productTitle);
}
