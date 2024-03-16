package com.lhepper.samurisespringbootbackend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.exception.NoDayException;
import com.lhepper.samurisespringbootbackend.pojo.Day;
import com.lhepper.samurisespringbootbackend.pojo.TestObject;
import com.lhepper.samurisespringbootbackend.repository.SamuriseRepository;

@Service
public class SamuriseServiceImpl implements SamuriseService {

    @Autowired
    SamuriseRepository samuriseRepository;

    // testing only
    @Override
    public TestObject getObjectByIndex(int index) {
        List<TestObject> list = samuriseRepository.getObjects();
        return list.get(index);
    }

    // testing only
    @Override
    public void saveObject(TestObject testObject) {
        samuriseRepository.saveObject(testObject);
    }

    @Override
    public Day getDayByID(UUID id) throws NoDayException {
        List<Day> days = samuriseRepository.getDays();
        Day result = null;

        System.out.println("REPO - getDayByID ==== " + id.toString() + " ===="); // TODO - for testing

        for (Day day : days) {
            if (day.getId().toString().equals(id.toString())) {
                result = day;
            }
        }

        if (result == null) {
            throw new NoDayException();
        }

        return result;
    }

}
