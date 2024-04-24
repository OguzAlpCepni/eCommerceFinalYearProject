package com.ecommerce.authenticationservice.service.rules;

import com.ecommerce.authenticationservice.core.exceptions.ServicesException;
import com.ecommerce.authenticationservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationRules {
    private UserRepository userRepository;

    public void checkIfUserNameExists(String name){
        if(this.userRepository.existsByName(name)){
            throw new ServicesException("user name already exists. ");
        }
    }
}
