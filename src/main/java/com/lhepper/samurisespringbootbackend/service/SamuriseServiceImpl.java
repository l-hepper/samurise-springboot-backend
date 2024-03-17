package com.lhepper.samurisespringbootbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.entity.TestObject;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;
import com.lhepper.samurisespringbootbackend.repository.SamuriseRepository;

@Service
public class SamuriseServiceImpl implements SamuriseService {

    @Autowired
    SamuriseRepository samuriseRepository;

    @Override
    public Optional<TestObject> getObjectById(int id) {
        Optional<TestObject> retrievedObject = samuriseRepository.findById(id);
        return retrievedObject;
    }

    @Override
    public void saveObject(TestObject testObject) {
        samuriseRepository.save(testObject);
    }

    @Override
    public Day getDayByID(UUID id) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDayByID'");
    }

    // // testing only
    // @Override
    // public TestObject getObjectByIndex(int index) {
    //     List<TestObject> list = samuriseRepository.getObjects();
    //     return list.get(index);
    // }

    // // testing only
    // @Override
    // public void saveObject(TestObject testObject) {
    //     samuriseRepository.saveObject(testObject);
    // }

    // @Override
    // public Day getDayByID(UUID id) throws ResourceNotFoundException {
    //     List<Day> days = samuriseRepository.getDays();
    //     Day result = null;

    //     System.out.println("REPO - getDayByID ==== " + id.toString() + " ===="); // TODO - for testing

    //     for (Day day : days) {
    //         if (day.getId().toString().equals(id.toString())) {
    //             result = day;
    //         }
    //     }

    //     if (result == null) {
    //         throw new ResourceNotFoundException(id);
    //     }

    //     return result;
    // }

    

}
