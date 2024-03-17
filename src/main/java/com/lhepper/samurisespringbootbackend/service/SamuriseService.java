package com.lhepper.samurisespringbootbackend.service;

import java.util.UUID;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.entity.TestObject;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;

public interface SamuriseService {

    // define every method that a service implementation must override
    TestObject getObjectByIndex(int index); // testonly
    void saveObject(TestObject testObject); // testonly

    Day getDayByID(UUID id) throws ResourceNotFoundException;


}