package orderservice.orderservice.core.Dtos;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemDto {
    private Long basketItemId;
    private Long basketId;
    @OneToOne
    private ItemDto item;
    private int quantity;
}
