package com.ecommerce.shippingservice.repository;

import com.ecommerce.shippingservice.Entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    Optional<ItemEntity>findByitemsku(@Param("itemsku")Long itemsku);
}
