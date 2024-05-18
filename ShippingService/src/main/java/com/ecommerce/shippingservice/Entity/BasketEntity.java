package com.ecommerce.shippingservice.Entity;

import com.ecommerce.shippingservice.core.util.BasketError;
import com.ecommerce.shippingservice.core.util.BasketStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name="basket")
@Data
public class BasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basketid")
    private Long basketId;
    @OneToMany
    private Collection<BasketItemEntity> basketItems = new HashSet<>();
    @Column(name = "basketstatus")
    private BasketStatus basketStatus;
    @Column(name = "baskedError")
    private BasketError basketError;
    public BasketEntity() {
    }

    public BasketEntity(Collection<BasketItemEntity> basketItems) {
        this.basketItems.addAll(basketItems);
        this.basketStatus = BasketStatus.ACTIVE;
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public Collection<BasketItemEntity> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(Collection<BasketItemEntity> basketItems) {
        this.basketItems = basketItems;
    }

    public BasketStatus getBasketStatus() {
        return basketStatus;
    }

    public void setBasketStatus(BasketStatus basketStatus) {
        this.basketStatus = basketStatus;
    }

    public BasketError getBasketError() {
        return basketError;
    }

    public void setBasketError(BasketError basketError) {
        this.basketError = basketError;
    }
}
