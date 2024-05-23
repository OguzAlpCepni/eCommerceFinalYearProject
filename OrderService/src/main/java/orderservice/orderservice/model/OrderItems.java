package orderservice.orderservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "orderitem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderitemid")
    private Long orderItemId;
    @Column(name = "producttitle")
    private String productTitle;
    @Column(name ="itemsku")
    private Long itemsku;
    @Column(name = "quantity")
    private int quantity;
    @Column(name="price")
    private BigDecimal priceUnit;

    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonBackReference
    private Order order;
}
