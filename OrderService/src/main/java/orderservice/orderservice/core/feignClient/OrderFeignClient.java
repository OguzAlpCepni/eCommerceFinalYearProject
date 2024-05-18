package orderservice.orderservice.core.feignClient;

import orderservice.orderservice.core.Dtos.BasketDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ShippingService",url="http://localhost:8087")
public interface OrderFeignClient {
    @GetMapping("/basket/content/{basketId}")
    BasketDto getCOntent(@PathVariable Long basketId);

}
