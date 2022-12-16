package com.workshop.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.store.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
