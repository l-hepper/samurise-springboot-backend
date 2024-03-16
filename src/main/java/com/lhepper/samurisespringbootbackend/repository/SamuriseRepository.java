package com.lhepper.samurisespringbootbackend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lhepper.samurisespringbootbackend.pojo.TestObject;
import com.lhepper.samurisespringbootbackend.pojo.TimeBlock;

@Repository
public class SamuriseRepository {

    // the two time - used to test set-up of layers
    List<TestObject> list = new ArrayList<>();

    // testing only
    public List<TestObject> getObjects() {
        return list;
    }

    // testing only
    public void saveObject(TestObject object) {
        list.add(object);
    }

    List<TimeBlock> timeBlockArray = new ArrayList<>();

    public List<TimeBlock> getTimeBlockArray() {
        return timeBlockArray;
    }

    public void addTimeBlock(TimeBlock timeBlock) {
        timeBlockArray.add(timeBlock);
    }

}
