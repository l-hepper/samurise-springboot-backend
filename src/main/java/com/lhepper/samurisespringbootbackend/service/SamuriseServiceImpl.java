package com.lhepper.samurisespringbootbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.repository.SamuriseRepository;

@Service
public class SamuriseServiceImpl implements SamuriseService {

    @Autowired
    SamuriseRepository samuriseRepository;

    @Override
    public String getWordByIndex(int index) {
        List<String> list = samuriseRepository.getWords();
        return list.get(index);
    }

    

}
