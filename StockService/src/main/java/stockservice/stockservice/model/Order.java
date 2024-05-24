package stockservice.stockservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stockservice.stockservice.core.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "orderid")
    private String OrderId;
    @Column(name = "baskedid")
    private Long basketId;
    @Column(name = "itemprice")
    private BigDecimal itemPrice;
    @Column(name="userid")
    private Long userId;
    @Column(name = "orderstatus")
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> orderItems;

}
