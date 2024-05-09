package com.ecommerce.shippingservice.service.abstracts;

import com.ecommerce.shippingservice.Entity.BasketEntity;

public interface BasketService {
    BasketEntity add(final long basketId, final long itemSku, final int itemQuantity);
}
