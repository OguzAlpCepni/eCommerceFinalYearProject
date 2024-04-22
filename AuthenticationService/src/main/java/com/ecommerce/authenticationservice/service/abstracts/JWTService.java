package com.ecommerce.authenticationservice.service.abstracts;

import org.springframework.stereotype.Service;


public interface JWTService {
    public void validateToken(final String token);
    public String generateToken(String userName);
}
