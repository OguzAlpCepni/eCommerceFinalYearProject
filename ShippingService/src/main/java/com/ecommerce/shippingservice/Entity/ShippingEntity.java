package com.ecommerce.shippingservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="shipping")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingEntity {
    @Id
    @Column(name = "shippingid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shippingId;
    @Column(name="productid")
    private Long productId;
    @Column(name="producttitle")
    private  String productTitle;
    @Column(name="priceunit")
    private Double priceUnit;
    @Column(name="quantity")
    private int quantity;

}
