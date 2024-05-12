package com.ecommerce.shippingservice.service.helper;

import com.ecommerce.shippingservice.Entity.BasketEntity;
import com.ecommerce.shippingservice.Entity.BasketItemEntity;
import com.ecommerce.shippingservice.core.util.BasketError;
import com.ecommerce.shippingservice.core.util.BusinessException;
import com.ecommerce.shippingservice.repository.BasketItemRepository;
import com.ecommerce.shippingservice.repository.BasketRepository;
import com.ecommerce.shippingservice.service.DTO.ItemDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class HelperBasketManager {
    private BasketRepository basketRepository;
    private BasketItemRepository basketItemRepository;
    public void checkItemDto(ItemDto itemDto){
        if(itemDto == null) {
            throw new BusinessException("could not found product for sku");
        }
    }
    public BasketEntity getBasket(Long basketId){
        BasketEntity basketEntity;
        Optional<BasketEntity> basketFound = basketRepository.findOneByBasketId(basketId);
        if(!basketFound.isPresent()){
            basketEntity = new BasketEntity();
            basketEntity.setBasketId(basketId);
            basketEntity = basketRepository.save(basketEntity);
        }else{
            basketEntity = basketFound.get();
        }
        return basketEntity;
    }
    public BasketEntity checkBasketForSku(BasketEntity basketEntity, BasketItemEntity basketItemEntity, Long itemsku, int quantity){
        if(basketEntity.getBasketItems().stream().anyMatch(i->i.getItem().getItemsku()==itemsku)){
            log.info("A");
            basketEntity.getBasketItems().forEach(i->{log.info("A");
                if(i.getItem().getItemsku()==itemsku){log.info("A");
                    i.setQuantity(i.getQuantity() + quantity);log.info("A");
                }log.info("A");
            });log.info("A");
        }else {log.info("A");
            basketEntity.getBasketItems().add((basketItemRepository.save(basketItemEntity)));log.info("A");
        }log.info("A");
        return basketRepository.save(basketEntity);
    }
    public boolean chechBasketForDelete(Optional<BasketEntity> basketEntity,Long itemSku,int quantity){
        if(basketEntity.isPresent()){
            basketEntity.get().getBasketItems().forEach(item->{
                if(item.getItem().getItemsku()==itemSku&&item.getQuantity()>=quantity){
                    basketEntity.get().getBasketItems().remove(item);
                    basketItemRepository.deleteById(item.getBasketId());
                }else {
                    item.setQuantity(item.getQuantity()-quantity);
                    basketItemRepository.save(item);
                }
            });
            return true;
        }else {
            return false;
        }

    }
    public BasketEntity updateForBasket(Optional<BasketEntity> basketEntity,Long itemsku,int quantity,Long basketId){
        if (basketEntity.isPresent()){
            basketEntity.get().getBasketItems().forEach(item->{
                if(item.getItem().getItemsku()==itemsku){
                    item.setQuantity(quantity);
                }
            });
            basketRepository.save(basketEntity.get());
        }else{
            BasketEntity basketBlank = new BasketEntity();
            basketBlank.setBasketError(new BasketError("could not find basket with ID"+basketId));
            return basketBlank;
        }
        return basketEntity.get();
    }
    public BigDecimal getBasketPrice(BasketEntity basketEntity){
        List<BigDecimal> values = new ArrayList<>();
        basketEntity.getBasketItems().forEach(val->values.add(val.getItem().getPrice().multiply(new BigDecimal(val.getQuantity()))));
        BigDecimal sumOfValues = values.stream().reduce(BigDecimal.ZERO,BigDecimal::add);
        return sumOfValues;
    }

}
