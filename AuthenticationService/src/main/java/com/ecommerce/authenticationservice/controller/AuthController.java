package com.ecommerce.authenticationservice.controller;

import com.ecommerce.authenticationservice.entity.User;
import com.ecommerce.authenticationservice.service.DTO.AuthRequest;
import com.ecommerce.authenticationservice.service.DTO.UserDTO;
import com.ecommerce.authenticationservice.service.abstracts.AuthenticationService;
import com.ecommerce.authenticationservice.service.rules.AuthenticationRules;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;
    private AuthenticationRules authenticationRules;
    private org.springframework.security.authentication.AuthenticationManager authmanager;
    @PostMapping("/register")
    public ResponseEntity addNewUser(@RequestBody @Valid() UserDTO userDTO){
        this.authenticationRules.checkIfUserNameExists(userDTO.getName());
        authenticationService.saveUser(userDTO);
        return ResponseEntity.ok("user added system");
    }

    @PostMapping("/token")
    public ResponseEntity getToken(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authmanager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()){
            return ResponseEntity.ok(authenticationService.generateToken(authRequest.getUsername()));
        }
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();


    }
    @GetMapping("/validate")
    public ResponseEntity validateToken(@RequestParam("token") String token){
        authenticationService.validateToken(token);
        return ResponseEntity.ok("Token is valid");

    }

}
