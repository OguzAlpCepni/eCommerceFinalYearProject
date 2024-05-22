package paymentservice.paymentservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paymentservice.paymentservice.Entity.Enum.OrderStatus;

import java.math.BigDecimal;

@Entity
@Table(name = "paymententity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymnetid")
    private Long paymentId;
    @Column(name = "orderamount")
    private BigDecimal orderAmount;
    @Column(name="userid")
    private Long userId;
    @Column(name = "orderstatus")
    private OrderStatus orderStatus;



}
