package paymentservice.paymentservice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentEntity {

    @Id
    @Column(name = "paymnetid")
    private String OrderId;
    @Column(name = "basketid")
    private Long basketId;
    @Column(name = "itemprice")
    private BigDecimal itemPrice;
    @Column(name="userid")
    private Long userId;

    @Column(name = "orderstatus")
    private OrderStatus orderStatus;



}
