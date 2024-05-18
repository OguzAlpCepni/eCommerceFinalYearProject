package orderservice.orderservice.controller;

import lombok.AllArgsConstructor;
import orderservice.orderservice.service.abstracts.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("order")
public class OrderController {

    private OrderService orderService;
    @RequestMapping(method = RequestMethod.POST,value = "/create/{basketId}/{userId}")
    ResponseEntity createOrder(@PathVariable Long basketId,@PathVariable Long userId){
        return ResponseEntity.ok(this.orderService.createOrder(basketId,userId));
    }

}
