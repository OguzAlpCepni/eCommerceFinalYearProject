package com.ecommerce.shippingservice.service.concreate;

import com.ecommerce.shippingservice.repository.BasketItemRepository;
import com.ecommerce.shippingservice.repository.BasketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasketManager {
    private BasketRepository basketRepository;
    private BasketItemRepository basketItemRepository;
}
