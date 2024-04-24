package com.ecommerce.authenticationservice.controller;

import com.ecommerce.authenticationservice.entity.User;
import com.ecommerce.authenticationservice.service.DTO.UserDTO;
import com.ecommerce.authenticationservice.service.abstracts.AuthenticationService;
import com.ecommerce.authenticationservice.service.rules.AuthenticationRules;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;
    private AuthenticationRules authenticationRules;
    @PostMapping("/register")
    public ResponseEntity addNewUser(@RequestBody @Valid() UserDTO userDTO){
        this.authenticationRules.checkIfUserNameExists(userDTO.getName());
        authenticationService.saveUser(userDTO);
        return ResponseEntity.ok("user added system");
    }

    @PostMapping("/token")
    public String getToken(User user){
        return authenticationService.generateToken(user.getName());
    }
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        authenticationService.validateToken(token);
        return "token is valid";

    }

}
