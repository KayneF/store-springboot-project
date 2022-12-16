package com.workshop.store.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.workshop.store.entities.User;
import com.workshop.store.entities.dto.UserDTO;
import com.workshop.store.repositories.UserRepository;
import com.workshop.store.services.exceptions.DatabaseException;
import com.workshop.store.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream()
                    .map(obj -> new UserDTO(obj))
                    .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> user = repository.findById(id);
        return new UserDTO(user.get());
    }

    public User insert(User user) {
        return repository.save(user);
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

    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            entity.setName(obj.getName());
            entity.setEmail(obj.getEmail());
            entity.setPhone(obj.getPhone());
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
