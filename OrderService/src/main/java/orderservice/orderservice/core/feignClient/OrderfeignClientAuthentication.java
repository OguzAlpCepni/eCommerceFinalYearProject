package orderservice.orderservice.core.feignClient;

import orderservice.orderservice.core.Dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

//@FeignClient(name="AuthenticationService",url="http://localhost:8085")
//public interface OrderfeignClientAuthentication {
//    @GetMapping("/getbyid")
//    UserDto getByIdForUser(@PathVariable("{getbyid}") Long id);


//}
