package com.ecommerce.shippingservice.core.feignClient;

import com.ecommerce.shippingservice.service.DTO.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ProductService",url="http://localhost:8086")
public interface BasketFeignClient {
    @GetMapping("/product/{itemsku}")
    ItemDto findByItemSku(@PathVariable("itemsku")  Long itemsku);
}
