package com.lhepper.samurisespringbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class SamuriseExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        String errorDetails = "Resource with ID: " + e.getId() + " not found.";
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND, errorDetails);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
