package com.workshop.store.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.workshop.store.entities.Category;
import com.workshop.store.repositories.CategoryRepository;
import com.workshop.store.services.exceptions.DatabaseException;
import com.workshop.store.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> cat = repository.findById(id);
        return cat.get();
    }

    public Category insert(Category category) {
        return repository.save(category);
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

    public Category update(Long id, Category obj) {
        try {
            Category cat = repository.getReferenceById(id);
            cat.setName(null);
            return repository.save(cat);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
