package orderservice.orderservice.service.concreate;

import orderservice.orderservice.core.Dtos.BasketDto;
import orderservice.orderservice.core.feignClient.OrderFeignClient;
import orderservice.orderservice.model.Order;
import orderservice.orderservice.service.abstracts.OrderService;

public class OrderManager implements OrderService {
    private OrderFeignClient orderFeignClient;
    @Override
    public void newOrder(Long basketId,Long userId) {
        Order order =new Order();
        BasketDto basketDto = orderFeignClient.getCOntent(basketId);
        basketDto.getBasketItems().stream().forEachOrdered(basketItemDto -> {
            order.setBasketId(basketItemDto.getBasketId());
            order.setQuantity(basketItemDto.getQuantity());
        });


    }
}
