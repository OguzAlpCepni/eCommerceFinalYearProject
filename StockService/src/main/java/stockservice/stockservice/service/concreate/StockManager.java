package stockservice.stockservice.service.concreate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import stockservice.stockservice.core.Dtos.ItemDto;
import stockservice.stockservice.core.Dtos.Order;
import stockservice.stockservice.core.enums.OrderStatus;
import stockservice.stockservice.core.feign.StockFeignClient;
import stockservice.stockservice.model.StockEntity;
import stockservice.stockservice.repository.StockRepository;
import stockservice.stockservice.service.abstracts.StockService;
@Service
@AllArgsConstructor
public class StockManager implements StockService {
    private final StockRepository stockRepository;
    private final StockFeignClient stockFeignClient;
    private final ObjectMapper objectMapper;



    @Override
    @KafkaListener(topics = "inventory-order-topic", groupId = "foo")
    public void processOrder(String message) {
        System.out.println("Received Message in group "+ message);
        StockEntity stockEntity = new StockEntity();
        Order order = null;

        try{
            order = objectMapper.readValue(message, Order.class);
        }catch (JsonProcessingException r){
            r.printStackTrace();
        }
        order.getOrderItems().forEach(orderItem -> {
            ItemDto itemDto = stockFeignClient.findByItemSku(orderItem.getItemsku());
            if(itemDto.getQuantity() >= orderItem.getQuantity()){
                int proccesQunatity = itemDto.getQuantity() - orderItem.getQuantity();
                itemDto.setQuantity(proccesQunatity);
                this.stockFeignClient.updateToSku(itemDto.getItemsku(),itemDto);

                stockEntity.setQuantity(proccesQunatity);
                stockEntity.setOrderStatus(OrderStatus.ControlledToStock);
                stockRepository.save(stockEntity);
            }else {
                stockEntity.setOrderStatus(OrderStatus.Disable);
                stockRepository.save(stockEntity);
            }
        });
    }
}
