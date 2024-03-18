package com.lhepper.samurisespringbootbackend.service;

import java.util.Optional;

import com.lhepper.samurisespringbootbackend.entity.Day;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;

public interface DayService {

    // define every method that a service implementation must override
    Day getDayByID(Long id) throws ResourceNotFoundException;

}