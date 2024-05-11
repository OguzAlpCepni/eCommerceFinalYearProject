package com.ecommerce.shippingservice.controller;

import com.ecommerce.shippingservice.Entity.BasketEntity;
import com.ecommerce.shippingservice.service.abstracts.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("basket")
public class BasketController {
    private BasketService basketService;
    @RequestMapping(method = RequestMethod.POST, value = "/add/{basketId}/{itemSku}/{itemQuantity}")
    ResponseEntity add(@PathVariable Long basketId, @PathVariable Long itemSku, @PathVariable int itemQuantity){
        return ResponseEntity.ok(basketService.add(basketId,itemSku,itemQuantity));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/remove/{basketId}/{itemSku}/{itemQuantity}")
    ResponseEntity delete(@PathVariable Long basketId, @PathVariable Long itemSku, @PathVariable int itemQuantity){
        return ResponseEntity.ok(basketService.delete(basketId,itemSku,itemQuantity));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/update/{basketId}/{itemSku}/{itemQuantity}")
    ResponseEntity update(@PathVariable Long basketId, @PathVariable Long itemSku, @PathVariable int itemQuantity){
        return ResponseEntity.ok(basketService.update(basketId, itemSku, itemQuantity));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/total/{basketId}")
    ResponseEntity getCOntent(@PathVariable Long basketId){
        return ResponseEntity.ok(basketService.getContent(basketId));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/total/{basketId}")
    ResponseEntity getTotal(@PathVariable Long basketId){
        return ResponseEntity.ok(basketService.getTotal(basketId));
    }


}
