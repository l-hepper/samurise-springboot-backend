package com.lhepper.samurisespringbootbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.pojo.TestObject;
import com.lhepper.samurisespringbootbackend.pojo.TimeBlock;
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
    public TimeBlock getTimeBlockByIndex(int index) {
        List<TimeBlock> list = samuriseRepository.getTimeBlockArray();
        return list.get(index);
    }

    @Override
    public List<TimeBlock> getTimeBlockArray() {
        return samuriseRepository.getTimeBlockArray();
    }

    @Override
    public void addTimeBlockObject(TimeBlock timeBlock) {
        samuriseRepository.addTimeBlock(timeBlock);
    }

}
