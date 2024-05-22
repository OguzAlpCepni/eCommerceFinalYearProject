package orderservice.orderservice.service.concreate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import orderservice.orderservice.core.Dtos.BasketDto;
import orderservice.orderservice.core.Dtos.UserDto;
import orderservice.orderservice.core.enums.OrderStatus;
import orderservice.orderservice.core.feignClient.OrderFeignClient;
import orderservice.orderservice.model.Order;
import orderservice.orderservice.model.OrderItems;
import orderservice.orderservice.repository.OrderRepository;
import orderservice.orderservice.service.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
    private OrderFeignClient orderFeignClient;
    //private OrderfeignClientAuthentication orderfeignClientAuthentication;
    private final OrderRepository orderRepository;
    private KafkaTemplate<String,String> kafkaTemplate;
    @Value("${order.topic.name}")
    private String topicName;
    ObjectMapper om = new ObjectMapper();

    @Override
    public Order createOrder(Long basketId,Long userId) {
        String orderId = UUID.randomUUID().toString();
        Order order =new Order();

        List<OrderItems> orderItems = new ArrayList<>();
        BasketDto basketDto = orderFeignClient.getCOntent(basketId);
        order.setBasketId(basketDto.getBasketId());
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setOrderStatus(OrderStatus.Active);
        basketDto.getBasketItems().stream().forEachOrdered(basketItemDto -> {
            OrderItems orderItem = new OrderItems();
            orderItem.setOrder(order);
            orderItem.setOrderItemId(basketItemDto.getItem().getProductId());
            orderItem.setProductTitle(basketItemDto.getItem().getProductTitle());
            orderItem.setItemsku(basketItemDto.getItem().getItemsku());
            orderItem.setQuantity(basketItemDto.getQuantity());
            orderItem.setPriceUnit(basketItemDto.getItem().getPriceUnit());
            orderItems.add(orderItem);

        });
        //UserDto userDto = orderfeignClientAuthentication.getByIdForUser(userId);
        //order.setUsername(userDto.getName());
        order.setOrderItems(orderItems);
        order.setItemPrice(orderFeignClient.getTotal(basketId));
        String message= null;
        try {
            message = om.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topicName,message);
        return orderRepository.save(order);
    }

}
