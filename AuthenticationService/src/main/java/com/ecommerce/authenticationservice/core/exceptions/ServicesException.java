package com.ecommerce.authenticationservice.core.exceptions;

public class ServicesException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ServicesException(String message){
        super(message);
    }
}
