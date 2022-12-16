package com.workshop.store.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.workshop.store.entities.Product;
import com.workshop.store.repositories.ProductRepository;
import com.workshop.store.services.exceptions.DatabaseException;
import com.workshop.store.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.get();
    }

    public Product insert(Product product) {
        return repository.save(product);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Product update(Long id, Product obj) {
        try {
            Product product = repository.getReferenceById(id);
            product.setName(obj.getName());
            product.setDescription(obj.getDescription());
            product.setPrice(obj.getPrice());
            product.setImgUrl(obj.getImgUrl());
            return repository.save(product);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
