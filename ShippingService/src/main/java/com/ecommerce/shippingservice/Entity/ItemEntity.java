package com.ecommerce.shippingservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name="item")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="itemid")
    private Long productId;

    @Column(name ="itemsku")
    private Long itemsku;

    @Column(name="price")
    private BigDecimal priceUnit;

}
