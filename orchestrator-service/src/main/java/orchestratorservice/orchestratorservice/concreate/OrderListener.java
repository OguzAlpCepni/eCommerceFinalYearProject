package orchestratorservice.orchestratorservice.concreate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.payment}")
    private String paymentTopic;

    @Value("${kafka.topic.inventory}")
    private String inventoryTopic;
    public OrderListener(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @KafkaListener(topics = "${kafka.topic.order}", groupId = "order_group")
    public void listen(@Payload Order order) {
        // Ödeme işlemini başlat
        kafkaTemplate.send(paymentTopic, order);
        // Envanter kontrolünü başlat
        kafkaTemplate.send(inventoryTopic, order);
    }
}
