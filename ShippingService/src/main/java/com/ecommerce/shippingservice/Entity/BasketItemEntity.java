package com.ecommerce.shippingservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="basketitem")
@Data
public class BasketItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketItemId;

    @Column(name = "baskedid")
    private Long basketId;

    @OneToOne
    @PrimaryKeyJoinColumn
    private ItemEntity item;

    @Column(name = "quantity")
    private int quantity;


    public BasketItemEntity() {
    }

    public BasketItemEntity(Long basketId, ItemEntity item, int quantity) {
        this.basketId = basketId;
        this.item = item;
        this.quantity = quantity;
    }

    public Long getBasketItemId() {
        return basketItemId;
    }

    public void setBasketItemId(Long basketItemId) {
        this.basketItemId = basketItemId;
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
