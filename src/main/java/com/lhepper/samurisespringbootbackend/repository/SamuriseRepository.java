package com.lhepper.samurisespringbootbackend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.entity.TestObject;

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

    List<Day> days = new ArrayList<>(List.of(new Day()));

    public List<Day> getDays() {
        return days;
    }
}
