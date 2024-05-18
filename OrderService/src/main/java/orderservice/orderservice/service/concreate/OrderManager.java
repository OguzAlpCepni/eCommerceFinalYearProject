package orderservice.orderservice.service.concreate;

import lombok.AllArgsConstructor;
import orderservice.orderservice.core.Dtos.BasketDto;
import orderservice.orderservice.core.Dtos.UserDto;
import orderservice.orderservice.core.enums.OrderStatus;
import orderservice.orderservice.core.feignClient.OrderFeignClient;
import orderservice.orderservice.model.Order;
import orderservice.orderservice.repository.OrderRepository;
import orderservice.orderservice.service.abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
    private OrderFeignClient orderFeignClient;
    //private OrderfeignClientAuthentication orderfeignClientAuthentication;
    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Long basketId,Long userId) {
        String orderId = UUID.randomUUID().toString();
        Order order =new Order();
        BasketDto basketDto = orderFeignClient.getCOntent(basketId);
        basketDto.getBasketItems().stream().forEachOrdered(basketItemDto -> {
            order.setBasketId(basketItemDto.getBasketId());
            order.setQuantity(basketItemDto.getQuantity());
        });
        //UserDto userDto = orderfeignClientAuthentication.getByIdForUser(userId);
        //order.setUsername(userDto.getName());
        order.setOrderId(orderId);
        order.setItemPrice(orderFeignClient.getTotal(basketId));
        order.setOrderStatus(OrderStatus.Active);
        orderRepository.save(order);
        return order;
    }
}
