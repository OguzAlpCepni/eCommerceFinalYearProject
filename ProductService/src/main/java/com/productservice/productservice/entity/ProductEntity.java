package com.productservice.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="productid" )
    private Long productId;
    @Column(name="producttitle")
    private String productTitle;
    @Column(name="imageurl")
    private String imageUrl;
    @Column(name="priceunit")
    private double priceUnit;
    @Column(name="quantity")
    private int quantity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid")
    private CategoryEntity categoryEntity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategoryEntity getCategory() {
        return categoryEntity;
    }

    public void setCategory(CategoryEntity category) {
        this.categoryEntity = category;
    }
}
