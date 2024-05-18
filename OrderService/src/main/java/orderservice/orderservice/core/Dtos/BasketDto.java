package orderservice.orderservice.core.Dtos;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {
    private Long basketId;
    @OneToMany
    private Collection<BasketItemDto> basketItems = new ArrayList<>();

}
