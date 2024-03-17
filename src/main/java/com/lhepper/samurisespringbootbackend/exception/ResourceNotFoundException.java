package com.lhepper.samurisespringbootbackend.exception;

import java.util.UUID;

// thrown when the requested day ID is not available in the database
public class ResourceNotFoundException extends RuntimeException {
    private String id;

    public ResourceNotFoundException(UUID id) {
        this.id = id.toString();
    }

    public String getId() {
        return id;
    }

}
