package com.ecommerce.shippingservice.core.feignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ProductService",url="http://localhost:8086/")
public interface ShippingFeignClient {



}
