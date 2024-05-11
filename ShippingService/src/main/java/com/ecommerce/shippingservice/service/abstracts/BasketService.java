package com.ecommerce.shippingservice.service.abstracts;

import com.ecommerce.shippingservice.Entity.BasketEntity;

import java.math.BigDecimal;

public interface BasketService {
    BasketEntity add(final Long basketId, final Long itemSku, final int itemQuantity);
    boolean delete(final Long basketId, final Long itemSku, final int itemQuantity);
    BasketEntity update(final Long basketId, final Long itemSku, final int itemQuantity);
    BasketEntity getContent(final Long basketId);

    BigDecimal getTotal(final Long basketId);
}
