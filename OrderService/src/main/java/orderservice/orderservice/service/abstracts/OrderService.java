package orderservice.orderservice.service.abstracts;

import orderservice.orderservice.core.Dtos.BasketDto;
import orderservice.orderservice.model.Order;

public interface OrderService {

    public Order createOrder(Long basketId, Long userId);
}
