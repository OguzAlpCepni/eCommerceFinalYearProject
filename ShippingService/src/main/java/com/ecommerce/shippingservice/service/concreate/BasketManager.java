package com.ecommerce.shippingservice.service.concreate;

import com.ecommerce.shippingservice.Entity.BasketEntity;
import com.ecommerce.shippingservice.Entity.BasketItemEntity;
import com.ecommerce.shippingservice.Entity.ItemEntity;
import com.ecommerce.shippingservice.core.feignClient.BasketFeignClient;
import com.ecommerce.shippingservice.core.mappers.ModelMapperService;
import com.ecommerce.shippingservice.core.util.BasketStatus;
import com.ecommerce.shippingservice.repository.BasketItemRepository;
import com.ecommerce.shippingservice.repository.BasketRepository;
import com.ecommerce.shippingservice.repository.ItemRepository;
import com.ecommerce.shippingservice.service.DTO.ItemDto;
import com.ecommerce.shippingservice.service.abstracts.BasketService;
import com.ecommerce.shippingservice.service.helper.HelperBasketManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class BasketManager implements BasketService {
    private BasketRepository basketRepository;
    private BasketFeignClient basketFeignClient;
    private HelperBasketManager helperBasketManager;
    private ModelMapperService modelMapperService;
    private ItemRepository itemRepository;
    private BasketItemRepository basketItemRepository;

    @Override
    public BasketEntity add(Long basketId, Long itemSku, int itemQuantity) {

        ItemDto itemDto = basketFeignClient.findByItemSku(itemSku);                                                     // ürünü aldım

        helperBasketManager.checkItemDto(itemDto);                                                                      // ürünü alabildim mi kontrolü

        BasketEntity basketEntity = helperBasketManager.getBasket(basketId);                                            // ürün sepette var mı yoksa sepet oluştur

        ItemEntity itemEntity = this.modelMapperService.forRequest().map(itemDto,ItemEntity.class);                     // sepete eklenmesi için gelen ürünü maple
        Optional<ItemEntity> existingItemEntity = itemRepository.findByitemsku(itemSku);
        // Eğer ürün zaten varsa kaydetme, yoksa kaydet
        if (!existingItemEntity.isPresent()) {
            itemRepository.save(itemEntity);
        } else {
            // Zaten mevcut olan ürünü kullan
            itemEntity = existingItemEntity.get();
        }
        BasketItemEntity basketItemEntity = new BasketItemEntity(basketEntity.getBasketId(),itemEntity,itemQuantity);// sepetin içine eklenecek olan ürün ve miktarı
        basketEntity=helperBasketManager.checkBasketForSku(basketEntity,basketItemEntity,itemSku,itemQuantity);
        return basketEntity;
    }

    @Override
    public boolean delete(Long basketId, Long itemSku, int itemQuantity) {
        Optional<BasketEntity> basketEntity = basketRepository.findOneByBasketId(basketId);
        if(basketEntity.isPresent()){
            basketEntity.get().getBasketItems().forEach(item->{
                if(item.getItem().getItemsku().equals(itemSku)&&item.getQuantity()>=itemQuantity){
                    basketEntity.get().getBasketItems().remove(item);
                    basketItemRepository.delete(item);
                }else {
                    item.setQuantity(item.getQuantity()-itemQuantity);
                    basketItemRepository.save(item);
                }
            });
            return true;
        }else {
            return false;
        }
    }

    @Override
    public BasketEntity update(Long basketId, Long itemSku, int itemQuantity) {
        Optional<BasketEntity> basketEntity = basketRepository.findOneByBasketId(basketId);
        return helperBasketManager.updateForBasket(basketEntity,itemSku,itemQuantity,basketId);
    }

    @Override
    public BasketEntity getContent(Long basketId) {
        return basketRepository.findOneByBasketId(basketId).get();
    }

    @Override
    public BigDecimal getTotal(Long basketId) {
        Optional<BasketEntity> basketEntity = basketRepository.findOneByBasketId(basketId);
        return helperBasketManager.getBasketPrice(basketEntity.get());
    }
}
