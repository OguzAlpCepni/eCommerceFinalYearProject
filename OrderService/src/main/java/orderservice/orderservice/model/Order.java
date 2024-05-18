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
    @Column(name = "baskedid")
    private Long basketId;
    @Column(name = "itemprice")
    private BigDecimal itemPrice;
    @Column(name=" quantity")
    private int quantity;
    @Column
    private String username;
    @Column(name = "address")
    private String address;
    @Column(name = "orderstatus")
    private OrderStatus orderStatus;

}
