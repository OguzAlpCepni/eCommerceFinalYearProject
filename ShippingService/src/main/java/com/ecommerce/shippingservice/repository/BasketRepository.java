package com.ecommerce.shippingservice.repository;

import com.ecommerce.shippingservice.Entity.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<BasketEntity,Long> {
    Optional<BasketEntity> findOneByBasketId(@Param("basketId") long basketId);
}
