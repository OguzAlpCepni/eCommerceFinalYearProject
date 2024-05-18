package orderservice.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import orderservice.orderservice.core.enums.OrderStatus;

import java.math.BigDecimal;

@Entity
@Table(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long OrderId;

    private Long basketId;
    private BigDecimal itemPrice;
    private OrderStatus orderStatus;

}
