package orderservice.orderservice.core.feignClient;

import orderservice.orderservice.core.Dtos.BasketDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

@FeignClient(name="ShippingService",url="http://localhost:8087")
public interface OrderFeignClient {
    @RequestMapping(method = RequestMethod.GET,value="/basket/content/{basketId}")
    BasketDto getCOntent(@PathVariable Long basketId);

    @RequestMapping(method = RequestMethod.GET, value = "/basket/total/{basketId}")
    BigDecimal getTotal(@PathVariable Long basketId);
}
