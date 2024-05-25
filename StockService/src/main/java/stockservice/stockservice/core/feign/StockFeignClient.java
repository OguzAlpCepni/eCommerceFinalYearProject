package stockservice.stockservice.core.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import stockservice.stockservice.core.Dtos.ItemDto;

@FeignClient(name = "ProductService",url="http://localhost:8086")
public interface StockFeignClient {
    @GetMapping("/product/{itemsku}")
    ItemDto findByItemSku(@PathVariable("itemsku")  Long itemsku);
}
