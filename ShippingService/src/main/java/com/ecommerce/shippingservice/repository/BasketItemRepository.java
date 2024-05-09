package com.ecommerce.shippingservice.repository;

import com.ecommerce.shippingservice.Entity.BasketItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BasketItemRepository extends JpaRepository<BasketItemEntity,Long> {
    List<BasketItemEntity> findBybasketItemId(@Param("basketItemId")long basketItemId);
}
