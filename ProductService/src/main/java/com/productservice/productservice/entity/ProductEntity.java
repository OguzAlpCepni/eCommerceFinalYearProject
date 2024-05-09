package com.productservice.productservice.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="productid" )
    private Long productId;
    @Column(name="producttitle")
    private String productTitle;
    @Column(name="imageurl")
    private String imageUrl;
    @Column(name="itemsku")
    private Long itemsku;
    @Column(name="priceunit")
    private double priceUnit;
    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name ="categoryid")
    private CategoryEntity categoryEntity;

}
