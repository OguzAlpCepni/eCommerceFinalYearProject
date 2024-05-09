package com.ecommerce.shippingservice.service.concreate;

import com.ecommerce.shippingservice.Entity.ShippingEntity;
import com.ecommerce.shippingservice.core.feignClient.ShippingFeignClient;
import com.ecommerce.shippingservice.core.mappers.ModelMapperService;
import com.ecommerce.shippingservice.repository.ShippingRepository;
import com.ecommerce.shippingservice.service.DTO.GetAllShippingDto;
import com.ecommerce.shippingservice.service.abstracts.ShippingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ShippingManager implements ShippingService {
    private ShippingRepository shippingRepository;
    private ModelMapperService modelMapperService;
    private ShippingFeignClient shippingFeignClient;
    @Override
    public List<GetAllShippingDto> getAll() {
        log.info(" fetch all profucts in shipping ");
        List<ShippingEntity> shippingEntities = this.shippingRepository.findAll();
        List<GetAllShippingDto> getAllShippingDtos = shippingEntities.stream().map(shippingEntity -> this.modelMapperService.forResponse().map(shippingEntity,GetAllShippingDto.class)).collect(Collectors.toList());
        return getAllShippingDtos;
    }

}
