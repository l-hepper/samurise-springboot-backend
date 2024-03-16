package com.lhepper.samurisespringbootbackend.service;

import java.util.UUID;

import com.lhepper.samurisespringbootbackend.exception.NoDayException;
import com.lhepper.samurisespringbootbackend.pojo.Day;
import com.lhepper.samurisespringbootbackend.pojo.TestObject;

public interface SamuriseService {

    // define every method that a service implementation must override
    TestObject getObjectByIndex(int index); // testonly
    void saveObject(TestObject testObject); // testonly

    Day getDayByID(UUID id) throws NoDayException;


}