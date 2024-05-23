package paymentservice.paymentservice.service.concreate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import paymentservice.paymentservice.Entity.Enum.OrderStatus;
import paymentservice.paymentservice.Entity.PaymentEntity;
import paymentservice.paymentservice.Entity.UserCard;
import paymentservice.paymentservice.repository.PaymentRepository;
import paymentservice.paymentservice.repository.UserCardRepository;
import paymentservice.paymentservice.service.abstracts.PaymentService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

    private  PaymentRepository paymentRepository;
    private UserCardRepository userCardRepository;

    @Override
    @KafkaListener(topics = "order-topic", groupId = "foo")
    public void processOrder(String message) {
        System.out.println("Received Message in group "+ message);
        ObjectMapper objectMapper = new ObjectMapper();
        PaymentEntity paymentEntity = null;
        try{
            paymentEntity = objectMapper.readValue(message,PaymentEntity.class);
            UserCard userCard = userCardRepository.findById(paymentEntity.getUserId()).orElseThrow();
            if(userCard.getAmount().compareTo(paymentEntity.getItemPrice())>=0){
                userCard.setAmount(userCard.getAmount().subtract(paymentEntity.getItemPrice()));
                paymentEntity.setOrderStatus(OrderStatus.Paid);
                userCardRepository.save(userCard);
                paymentRepository.save(paymentEntity);

            }else {
                paymentEntity.setOrderStatus(OrderStatus.Disable);
                paymentRepository.save(paymentEntity);
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }


    }
}
