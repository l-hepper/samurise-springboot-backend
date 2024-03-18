package com.lhepper.samurisespringbootbackend.exception;

// thrown when the requested day ID is not available in the database
public class ResourceNotFoundException extends RuntimeException {
    private long id;

    public ResourceNotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
