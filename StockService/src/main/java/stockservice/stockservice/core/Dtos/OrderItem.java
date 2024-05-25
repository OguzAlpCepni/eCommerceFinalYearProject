package stockservice.stockservice.core.Dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private Long orderItemId;

    private String productTitle;

    private Long itemsku;

    private int quantity;

    private BigDecimal priceUnit;

    @ManyToOne
    private Order order;
}
