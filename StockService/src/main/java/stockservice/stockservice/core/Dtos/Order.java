package stockservice.stockservice.core.Dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stockservice.stockservice.core.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String OrderId;

    private Long basketId;

    private BigDecimal itemPrice;

    private Long userId;

    private OrderStatus orderStatus;
    @OneToMany()
    private List<OrderItem> orderItems;
}
