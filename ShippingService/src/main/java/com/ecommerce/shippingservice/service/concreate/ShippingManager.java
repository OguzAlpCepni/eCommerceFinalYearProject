package com.ecommerce.shippingservice.service.concreate;

import com.ecommerce.shippingservice.repository.ShippingRepository;
import com.ecommerce.shippingservice.service.DTO.GetAllShippingDto;
import com.ecommerce.shippingservice.service.abstracts.ShippingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShippingManager implements ShippingService {
    private ShippingRepository shippingRepository;
    @Override
    public GetAllShippingDto getAll() {
        return null;
    }
}
