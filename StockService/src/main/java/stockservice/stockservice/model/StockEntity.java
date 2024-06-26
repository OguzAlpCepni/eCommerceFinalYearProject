package stockservice.stockservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stockservice.stockservice.core.enums.OrderStatus;

@Entity
@Table(name = "stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stockid")
    private Long id;
    @Column(name = "quantity")
    private int quantity;

    @Column(name= "orderstatus")
    private OrderStatus orderStatus;
}
