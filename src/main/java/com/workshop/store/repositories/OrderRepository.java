package com.workshop.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.store.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
