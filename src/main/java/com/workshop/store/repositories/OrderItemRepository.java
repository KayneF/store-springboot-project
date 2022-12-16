package com.workshop.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.store.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
