package com.lhepper.samurisespringbootbackend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.lhepper.samurisespringbootbackend.pojo.Day;
import com.lhepper.samurisespringbootbackend.pojo.TestObject;

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

    @SuppressWarnings("null")
    public Day getDayByID(UUID id) {
        // TODO - if the day cannot be found by the ID then ensure that this is handled
        Day result = null;
        System.out.println("REPO - getDayByID ==== " + id.toString() + " ===="); // TODO - for testing
        for (Day day : days) {
            if (day.getId().toString().equals(id.toString())) {
                result = day;
            }
        }
        System.out.println(result.getId().toString());
        return result;
    }
}
