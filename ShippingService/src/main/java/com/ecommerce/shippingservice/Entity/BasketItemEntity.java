package com.ecommerce.shippingservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="basketitem")
@Data
public class BasketItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long basketItemId;

    private long basketId;

    @OneToOne
    private ItemEntity item;

    private int quantity;

    public BasketItemEntity() {
    }

    public BasketItemEntity(long basketId, ItemEntity item, int quantity) {
        this.basketId = basketId;
        this.item = item;
        this.quantity = quantity;
    }

    public long getBasketItemId() {
        return basketItemId;
    }

    public void setBasketItemId(long basketItemId) {
        this.basketItemId = basketItemId;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
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
