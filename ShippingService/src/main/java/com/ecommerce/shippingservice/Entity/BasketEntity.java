package com.ecommerce.shippingservice.Entity;

import com.ecommerce.shippingservice.core.util.BasketError;
import com.ecommerce.shippingservice.core.util.BasketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="basket")
@Data
public class BasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basketid")
    private Long basketId;
    @OneToMany
    private Collection<BasketItemEntity> basketItems = new ArrayList<>();
    @Column(name = "basketstatus")
    private BasketStatus basketStatus;

    @Column(name = "created")
    private DateTime created;
    @Column(name = "baskedError")
    private BasketError basketError;
    public BasketEntity() {
    }

    public BasketEntity(Collection<BasketItemEntity> basketItems) {
        this.basketItems.addAll(basketItems);
        this.basketStatus = BasketStatus.ACTIVE;
        this.created = DateTime.now();
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
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

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public BasketError getBasketError() {
        return basketError;
    }

    public void setBasketError(BasketError basketError) {
        this.basketError = basketError;
    }
}
