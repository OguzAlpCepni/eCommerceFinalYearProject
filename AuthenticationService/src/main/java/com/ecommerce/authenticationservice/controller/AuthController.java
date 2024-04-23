package com.ecommerce.authenticationservice.controller;

import com.ecommerce.authenticationservice.entity.User;
import com.ecommerce.authenticationservice.service.DTO.UserDTO;
import com.ecommerce.authenticationservice.service.abstracts.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDTO userDTO){
        return authenticationService.saveUser(userDTO);
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
