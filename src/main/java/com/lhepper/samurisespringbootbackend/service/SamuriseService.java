package com.lhepper.samurisespringbootbackend.service;

import java.util.List;

import com.lhepper.samurisespringbootbackend.pojo.TestObject;
import com.lhepper.samurisespringbootbackend.pojo.TimeBlock;

public interface SamuriseService {

    // define every method that a service implementation must override
    TestObject getObjectByIndex(int index); // testonly
    void saveObject(TestObject testObject); // testonly

    TimeBlock getTimeBlockByIndex(int index);
    List<TimeBlock> getTimeBlockArray();

    void addTimeBlockObject(TimeBlock timeBlock);

}