package com.workshop.store.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(Object id) {
        super("Reource not found. Id: " + id);
    }
}
