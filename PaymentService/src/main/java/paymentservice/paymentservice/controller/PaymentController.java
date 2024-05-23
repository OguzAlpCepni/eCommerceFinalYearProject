package paymentservice.paymentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import paymentservice.paymentservice.Entity.UserCard;
import paymentservice.paymentservice.service.abstracts.PaymentService;
import paymentservice.paymentservice.service.abstracts.UserCardService;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;
    private UserCardService userCardService;




    @PostMapping
    public ResponseEntity addCard(@RequestBody UserCard userCard){
        userCardService.add(userCard);
        return ResponseEntity.ok("added user card");
    }

}
