package com.ecommerce.shippingservice.service.abstracts;

import com.ecommerce.shippingservice.service.DTO.GetAllShippingDto;

import java.util.List;

public interface ShippingService {
    List<GetAllShippingDto> getAll();


}
