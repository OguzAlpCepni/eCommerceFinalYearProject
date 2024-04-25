package com.ecommerce.authenticationservice.service.concreate;

import com.ecommerce.authenticationservice.core.mappers.ModelMapperService;
import com.ecommerce.authenticationservice.entity.User;
import com.ecommerce.authenticationservice.repository.UserRepository;
import com.ecommerce.authenticationservice.service.DTO.UserDTO;
import com.ecommerce.authenticationservice.service.abstracts.AuthenticationService;
import com.ecommerce.authenticationservice.service.abstracts.JWTService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationManager implements AuthenticationService {
    private ModelMapperService modelMapperService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTService jwtService;


    @Override
    public String saveUser(UserDTO userDTO) {
        User user = this.modelMapperService.forRequest().map(userDTO,User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return "user added to the system";
    }

    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
