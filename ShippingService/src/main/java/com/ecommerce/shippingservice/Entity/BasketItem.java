package com.ecommerce.shippingservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="basketitem")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="basketitemid")
    private Long basketItemId;
    @Column(name ="itemsku")
    private long itemsku;

    @Column(name="price")
    private double price;
    @Column(name="quantity")
    private int quantity;
}
