package orderservice.orderservice.service.abstracts;

import orderservice.orderservice.core.Dtos.BasketDto;

public interface OrderService {

    public void newOrder(Long basketId,Long userId);
}
