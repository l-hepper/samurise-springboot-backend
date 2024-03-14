package com.lhepper.samurisespringbootbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.repository.SamuriseRepository;

@Service
public class SamuriseService {

    @Autowired
    SamuriseRepository samuriseRepository;

}
