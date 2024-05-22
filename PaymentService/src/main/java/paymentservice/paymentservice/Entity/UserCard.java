package paymentservice.paymentservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "usercard")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usercardid")
    private Long userCardId;
    private String cardNumber;
    private String cvc;
    private BigDecimal amount;

}
