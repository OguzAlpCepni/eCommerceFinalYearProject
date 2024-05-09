package com.ecommerce.shippingservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="item")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="itemid")
    private Long itemId;
    @Column(name ="itemsku")
    private long itemsku;

    @Column(name="price")
    private double price;
    @Column(name="quantity")
    private int quantity;
}
