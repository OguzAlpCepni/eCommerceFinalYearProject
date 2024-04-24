package com.ecommerce.authenticationservice.repository;

import com.ecommerce.authenticationservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String userName);
    boolean existsByName(String name);
}