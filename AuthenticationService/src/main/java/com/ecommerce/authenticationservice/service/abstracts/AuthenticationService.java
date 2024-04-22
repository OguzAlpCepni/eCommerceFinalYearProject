package com.ecommerce.authenticationservice.service.abstracts;

import com.ecommerce.authenticationservice.service.DTO.UserDTO;

public interface AuthenticationService {

    public String saveUser(UserDTO userDTO);

    public String generateToken(String username);

    public void validateToken(String token);


}