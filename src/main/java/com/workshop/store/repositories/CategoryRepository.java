package com.workshop.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.store.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
