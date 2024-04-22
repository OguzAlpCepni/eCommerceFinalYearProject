package com.ecommerce.authenticationservice.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String name;
    private String email;
    private String password;
}
