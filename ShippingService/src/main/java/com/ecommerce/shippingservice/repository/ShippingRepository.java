package com.ecommerce.shippingservice.repository;

import com.ecommerce.shippingservice.Entity.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<ShippingEntity,Integer> {
}
